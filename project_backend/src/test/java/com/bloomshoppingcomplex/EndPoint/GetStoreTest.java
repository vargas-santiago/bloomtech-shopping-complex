package com.bloomshoppingcomplex.EndPoint;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import com.bloomshoppingcomplex.Exceptions.StoreNotFoundException;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;
import com.bloomshoppingcomplex.Helpers.AccountHelper;
import com.bloomshoppingcomplex.Helpers.StoreHelper;
import com.bloomshoppingcomplex.Models.Request.GetAccountRequest;
import com.bloomshoppingcomplex.Models.Request.GetStoreRequest;
import com.bloomshoppingcomplex.Models.result.GetAccountResult;
import com.bloomshoppingcomplex.Models.result.GetStoreResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetStoreTest {

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

        List<Store> accountsResult = mapper.scan(Store.class, scanExpression);

        for (Store store : accountsResult) {
            storeDao.deleteStore(store);
        }
    }

    @Test
    void GetStoreGetsTheCorrectStore() {
        List<Store> stores = StoreHelper.generateStoreList(5, 3);
        List<GetStoreRequest> getStoreRequests = new ArrayList<>();
        GetStore getStore = new GetStore(storeDao);

        //Populates store table
        for (Store store : stores) {
            storeDao.saveStore(store);
        }

        //Makes the requests
        for (Store store : stores) {
            GetStoreRequest request = new GetStoreRequest().builder()
                    .withStoreId(store.getStoreId())
                    .build();

            getStoreRequests.add(request);
        }

        for (int i = 0; i < getStoreRequests.size(); i++) {
            boolean storesEqual = false;
            GetStoreResult getAccountResult = getStore.handleRequest(getStoreRequests.get(i), null);

            if (getAccountResult.getStore().toStore().equals(stores.get(i))) {
                storesEqual = true;
            }

            assertTrue(storesEqual);
        }
    }

    @Test
    void GetStoreWithNonExistingStoreIdThrowsException() {
        List<Store> stores = StoreHelper.generateStoreList(5, 3);
        List<GetStoreRequest> getStoreRequests = new ArrayList<>();
        GetStore getStore = new GetStore(storeDao);

        //Makes the requests
        for (Store store : stores) {
            GetStoreRequest request = new GetStoreRequest().builder()
                    .withStoreId(store.getStoreId())
                    .build();

            getStoreRequests.add(request);
        }

        for (GetStoreRequest getAccountRequest : getStoreRequests) {
            assertThrows(StoreNotFoundException.class, () -> getStore.handleRequest(getAccountRequest, null));
        }
    }
}
