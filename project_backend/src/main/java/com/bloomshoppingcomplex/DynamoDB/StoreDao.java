package com.bloomshoppingcomplex.DynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.Exceptions.StoreNotFoundException;

import javax.inject.Inject;

public class StoreDao {
    private final DynamoDBMapper dynamoDbMapper;

    /**
     * Instantiates a StoreDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the store table
     */
    @Inject
    public StoreDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    /**
     * Returns the {@link Store} corresponding to the specified id.
     *
     * @param storeId the Store ID
     * @return the stored Store, or null if none was found.
     */
    public Store getStore(String storeId) {
        Store store = this.dynamoDbMapper.load(Store.class, storeId);

        if (storeId == null) {
            throw new StoreNotFoundException("Could not find store with id " + storeId);
        }

        return store;

    }

    public Store saveStore(Store store) {
        this.dynamoDbMapper.save(store);
        return store;
    }
}
