package com.bloomshoppingcomplex.EndPoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Converter.ModelConverter;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import com.bloomshoppingcomplex.Exceptions.StoreNotFoundException;
import com.bloomshoppingcomplex.Models.Request.UpdateStoreRequest;
import com.bloomshoppingcomplex.Models.StoreModel;
import com.bloomshoppingcomplex.Models.result.UpdateStoreResult;
import com.bloomshoppingcomplex.Util.AccountUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateStore implements RequestHandler<UpdateStoreRequest, UpdateStoreResult> {
    private final Logger log = LogManager.getLogger();
    private final StoreDao storeDao;

    @Inject
    public UpdateStore(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
    public UpdateStoreResult handleRequest(final UpdateStoreRequest updateStoreRequest, Context context) {
        log.info("Received GetStoreInfoRequest{}", updateStoreRequest);
        String storeToUpdate = updateStoreRequest.getStoreId();

        Store store = storeDao.getStore(storeToUpdate);

        if (store == null) {
            throw new StoreNotFoundException(storeToUpdate + " Store ID not found.");
        }

        if (updateStoreRequest.getName() != null && AccountUtils.isValidString(updateStoreRequest.getName())) {
            store.setName(updateStoreRequest.getName());
        }

        if (updateStoreRequest.getCategory() != null) {
            store.setCategories(updateStoreRequest.getCategory());
        }

        if (updateStoreRequest.getItems() != null) {
            store.setItems(updateStoreRequest.getItems());
        }

        if ((Integer) updateStoreRequest.getPopularity() != null) {
            store.setPopularity(updateStoreRequest.getPopularity());
        }

        storeDao.saveStore(store);

        StoreModel storeModel = new ModelConverter().toStoreModel(store);

        return UpdateStoreResult.builder()
                .withStoreModel(storeModel)
                .build();
    }
}
