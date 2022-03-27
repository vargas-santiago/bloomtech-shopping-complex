package com.bloomshoppingcomplex.EndPoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Converter.ModelConverter;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import com.bloomshoppingcomplex.Models.StoreModel;
import com.bloomshoppingcomplex.Request.GetStoreInfoRequest;
import com.bloomshoppingcomplex.Request.result.GetStoreInfoResult;

import main.java.com.bloomshoppingcomplex.DynamoDB.StoreTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetStoreInfo implements RequestHandler<GetStoreInfoRequest, GetStoreInfoResult> {
    private final Logger log = LogManager.getLogger();
    private final StoreDao storeDao;

    @Inject
    public GetStoreInfo(StoreDao storeDao) { this.storeDao = storeDao; }

    @Override
    public GetStoreInfoResult handleRequest(final GetStoreInfoRequest getStoreInfoRequest, Context context) {
        log.info("Received GetStoreInfoRequest{}", getStoreInfoRequest);
        String requestedStoreId = getStoreInfoRequest.getStoreId();
        StoreTable store = storeDao.getStore(requestedStoreId);
        StoreModel storeModel = new ModelConverter().toStoreModel(store);

        return GetStoreInfoResult.builder()
                .withStore(storeModel)
                .build();

    }
}
