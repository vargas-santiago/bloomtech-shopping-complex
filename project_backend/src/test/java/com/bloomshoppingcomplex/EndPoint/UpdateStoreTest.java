package com.bloomshoppingcomplex.EndPoint;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.bloomshoppingcomplex.DynamoDB.Models.Item;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import com.bloomshoppingcomplex.Exceptions.StoreNotFoundException;
import com.bloomshoppingcomplex.Helpers.StoreHelper;
import com.bloomshoppingcomplex.Models.Request.GetStoreRequest;
import com.bloomshoppingcomplex.Models.Request.UpdateStoreRequest;
import com.bloomshoppingcomplex.Models.result.GetStoreResult;
import com.bloomshoppingcomplex.Models.result.UpdateStoreResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpdateStoreTest {

    private DynamoDBMapper mapper;
    private StoreDao storeDao;

    private AmazonDynamoDB client;
    private DynamoDBMapperConfig mapperConfig;

    @BeforeEach
    void initDao() {
        mapper = new DynamoDBMapper(client);
        storeDao = new StoreDao(mapper);
    }

    @BeforeEach
    void initAWS() {
        client = DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_1);

    }

    @AfterEach
    void cleanTables() {
        mapperConfig = new DynamoDBMapperConfig.Builder().withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement("stores")).build();

        DynamoDBMapper mapper = new DynamoDBMapper(client, mapperConfig);
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

        List<Store> storeResults = mapper.scan(Store.class, scanExpression);

        for (Store store : storeResults) {
            storeDao.deleteStore(store);
        }
    }

    @Test
    void UpdateStoreUpdatesCorrectly() {
        List<Store> stores = StoreHelper.generateStoreList(5, 3);
        List<Store> stores2 = StoreHelper.generateStoreList(5, 3);
        List<UpdateStoreRequest> updateStoreRequests = new ArrayList<>();
        UpdateStore updateStore = new UpdateStore(storeDao);

        for (Store store : stores2) {
            store.setName(store.getName() + "NEW");

            List<String> items = store.getItems();
            items.add("NEWITEM");
            store.setItems(items);

            List<String> categories = store.getCategories();
            categories.add("NEWCATEGORY");
            store.setCategories(categories);

            store.setPopularity(store.getPopularity() + 99);
        }

        //Populates store table
        for (Store store : stores) {
            storeDao.saveStore(store);
        }

        //Makes the requests
        for (Store store : stores2) {
            UpdateStoreRequest request = new UpdateStoreRequest().builder()
                    .withStoreId(store.getStoreId())
                    .withName(store.getName())
                    .withItems(store.getItems())
                    .withCategories(store.getCategories())
                    .withPopularity(store.getPopularity())
                    .build();

            updateStoreRequests.add(request);
        }

        for (int i = 0; i < updateStoreRequests.size(); i++) {
            boolean storesUpdates = false;
            UpdateStoreResult getAccountResult = updateStore.handleRequest(updateStoreRequests.get(i), null);

            if (storeDao.getStore(getAccountResult.getStoreModel().getStoreId()).equals(stores2.get(i))) {
                storesUpdates = true;
            }

            assertTrue(storesUpdates);
        }
    }

    @Test
    void GetAcountWithNonExistingUserIdThrowsException() {
        List<Store> stores = StoreHelper.generateStoreList(5, 3);
        List<UpdateStoreRequest> updateStoreRequests = new ArrayList<>();
        UpdateStore updateStore = new UpdateStore(storeDao);

        //Makes the requests
        for (Store store : stores) {
            UpdateStoreRequest request = new UpdateStoreRequest().builder()
                    .withStoreId(store.getStoreId())
                    .build();

            updateStoreRequests.add(request);
        }

        for (UpdateStoreRequest updateStoreRequest : updateStoreRequests) {
            assertThrows(StoreNotFoundException.class, () -> updateStore.handleRequest(updateStoreRequest, null));
        }
    }
}
