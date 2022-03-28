package com.bloomshoppingcomplex.EndPoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Converter.ModelConverter;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import com.bloomshoppingcomplex.Exceptions.StoreNotFoundException;
import com.bloomshoppingcomplex.Models.StoreModel;
import com.bloomshoppingcomplex.Models.Request.GetStoreInfoRequest;
import com.bloomshoppingcomplex.Models.result.GetStoreInfoResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetStoreInfo implements RequestHandler<GetStoreInfoRequest, GetStoreInfoResult> {
    private final Logger log = LogManager.getLogger();
    private final StoreDao storeDao;

    @Inject
    public GetStoreInfo(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
    public GetStoreInfoResult handleRequest(final GetStoreInfoRequest getStoreInfoRequest, Context context) {
        log.info("Received GetStoreInfoRequest{}", getStoreInfoRequest);
        String requestedStoreId = getStoreInfoRequest.getStoreId();

        if (requestedStoreId == null) {
            throw new StoreNotFoundException(requestedStoreId + " Store ID not found.");
        }

        Store store = storeDao.getStore(requestedStoreId);
        StoreModel storeModel = new ModelConverter().toStoreModel(store);

        return GetStoreInfoResult.builder()
                .withStore(storeModel)
                .build();
    }
}
