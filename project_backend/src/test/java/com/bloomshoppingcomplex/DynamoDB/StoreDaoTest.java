package com.bloomshoppingcomplex.DynamoDB;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.Exceptions.StoreNotFoundException;
import com.bloomshoppingcomplex.Helpers.StoreHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StoreDaoTest {

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

        List<Store> storesResult = mapper.scan(Store.class, scanExpression);

        for (Store store : storesResult) {
            storeDao.deleteStore(store);
        }
    }

    @Test
    void itemReturnedEqualsItemSaved() {

        List<Store> stores = StoreHelper.generateStoreList(3, 5);

        for (Store store : stores) {
            boolean storesEqual = false;
            Store storeExpected = store;

            storeDao.saveStore(store);
            Store storeReturned = storeDao.getStore(storeExpected.getStoreId());

            if (storeReturned.equals(storeExpected)) {
                storesEqual = true;
            }
            assertTrue(storesEqual);
        }
    }


    @Test
    void RetrievingNonExistingStoreThrowsStoreNotFoundException() {

        List<Store> stores = StoreHelper.generateStoreList(5, 5);

        for (Store store : stores) {
            Store storeExpected = store;

            assertThrows(StoreNotFoundException.class, () -> storeDao.getStore(storeExpected.getStoreId()));
        }
    }
}
