package com.bloomshoppingcomplex.EndPoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Converter.ModelConverter;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import com.bloomshoppingcomplex.Exceptions.StoreNotFoundException;
import com.bloomshoppingcomplex.Models.StoreModel;
import com.bloomshoppingcomplex.Models.Request.GetStoreRequest;
import com.bloomshoppingcomplex.Models.result.GetStoreResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetStore implements RequestHandler<GetStoreRequest, GetStoreResult> {
    private final Logger log = LogManager.getLogger();
    private final StoreDao storeDao;

    @Inject
    public GetStore(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
    public GetStoreResult handleRequest(final GetStoreRequest getStoreRequest, Context context) {
        log.info("Received GetStoreRequest{}", getStoreRequest);
        Store store = storeDao.getStore(getStoreRequest.getStoreId());

        if (store == null) {
            throw new StoreNotFoundException(getStoreRequest.getStoreId() + " Store ID not found.");
        }

        StoreModel storeModel = new ModelConverter().toStoreModel(store);

        return GetStoreResult.builder()
                .withStoreModel(storeModel)
                .build();
    }
}
