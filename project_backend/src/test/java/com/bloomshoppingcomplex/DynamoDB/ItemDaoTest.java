package com.bloomshoppingcomplex.DynamoDB;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.bloomshoppingcomplex.DynamoDB.Models.Item;
import com.bloomshoppingcomplex.DynamoDB.Models.ItemTest;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.Exceptions.ItemNotFoundException;
import com.bloomshoppingcomplex.Helpers.ItemHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemDaoTest {

    private DynamoDBMapper mapper;
    private ItemDao itemDao;

    private AmazonDynamoDB client;
    private DynamoDBMapperConfig mapperConfig;

    @BeforeEach
    void initDao() {
        mapper = new DynamoDBMapper(client);
        itemDao = new ItemDao(mapper);
    }

    @BeforeEach
    void initAWS() {
        client = DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_1);
    }

    @AfterEach
    void cleanTables() {
        mapperConfig = new DynamoDBMapperConfig.Builder().withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement("items")).build();

        DynamoDBMapper mapper = new DynamoDBMapper(client, mapperConfig);
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

        List<Item> itemsResult = mapper.scan(Item.class, scanExpression);

        for (Item item : itemsResult) {
            itemDao.deleteItem(item);
        }
    }

    @Test
    void itemReturnedEqualsItemSaved() {

        List<Item> items = ItemHelper.generateItemList(3);

        for (Item item : items) {
            boolean itemsEqual = false;
            Item itemExpected = item;

            itemDao.saveItem(item);
            Item itemReturned = itemDao.getItem(itemExpected.getItemId(), itemExpected.getStoreId());

            if (itemReturned.equals(itemExpected)) {
                itemsEqual = true;
            }
            assertTrue(itemsEqual);
        }
    }


    @Test
    void RetrievingNonExistingItemThrowsItemNotFoundException() {

        List<Item> items = ItemHelper.generateItemList(10);

        for (Item item : items) {
            Item itemExpected = item;

            assertThrows(ItemNotFoundException.class, () -> itemDao.getItem(itemExpected.getItemId(), itemExpected.getStoreId()));
        }
    }
}
