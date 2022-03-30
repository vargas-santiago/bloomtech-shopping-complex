package com.bloomshoppingcomplex.DynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomshoppingcomplex.DynamoDB.Models.Item;
import com.bloomshoppingcomplex.Exceptions.ItemNotFoundException;

public class ItemDao {
    private final DynamoDBMapper dynamoDbMapper;

    /**
     * Instantiates a ItemDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the items table
     */

    public ItemDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    /**
     * Returns the {@link Item} corresponding to the specified id.
     *
     * @param itemId the Item ID
     * @param storeName the storeName
     * @return the stored Item, or null if none was found.
     */
    public Item getItem (String itemId, String storeName) {
        Item item = this.dynamoDbMapper.load(Item.class, itemId, storeName);

        if (item == null) {
            throw new ItemNotFoundException("Could not find item with id " + itemId + " in store " + storeName);
        }

        return item;

    }

    public Item saveItem(Item saveItem) {
        this.dynamoDbMapper.save(saveItem);
        return saveItem;
    }

    public Item deleteItem(Item deleteItem) {
        this.dynamoDbMapper.delete(deleteItem);
        return deleteItem;
    }
}
