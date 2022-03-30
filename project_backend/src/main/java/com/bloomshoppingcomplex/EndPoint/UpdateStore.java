package com.bloomshoppingcomplex.EndPoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Converter.ModelConverter;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
<<<<<<< HEAD
=======
import com.bloomshoppingcomplex.Exceptions.InvalidAttributeChangeException;
import com.bloomshoppingcomplex.Exceptions.InvalidCharacterException;
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f
import com.bloomshoppingcomplex.Exceptions.StoreNotFoundException;
import com.bloomshoppingcomplex.Models.Request.UpdateStoreRequest;
import com.bloomshoppingcomplex.Models.StoreModel;
import com.bloomshoppingcomplex.Models.result.UpdateStoreResult;
<<<<<<< HEAD
import com.bloomshoppingcomplex.Util.AccountUtils;
=======
import com.bloomshoppingcomplex.Util.StoreUtils;
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
<<<<<<< HEAD
=======
import javax.management.InvalidAttributeValueException;
import java.util.List;
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f

public class UpdateStore implements RequestHandler<UpdateStoreRequest, UpdateStoreResult> {
    private final Logger log = LogManager.getLogger();
    private final StoreDao storeDao;

    @Inject
    public UpdateStore(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
<<<<<<< HEAD
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
=======
    public UpdateStoreResult handleRequest(final UpdateStoreRequest updateStoreRequest, Context context)
        throws StoreNotFoundException, InvalidAttributeChangeException, InvalidCharacterException {
        log.info("Received UpdateStoreRequest {}", updateStoreRequest);

        String storeId = updateStoreRequest.getStoreId();
        String storeName = updateStoreRequest.getName();
        boolean isStoreNameValid = StoreUtils.isValidString(storeName);

        if (storeId == null) {
            throw new StoreNotFoundException("Store ID does not exist.");
        } else if (!isStoreNameValid) {
            throw new InvalidCharacterException("Store name contains invalid characters.");
        }

        Store storeDB = storeDao.getStore(storeId);

        if (!storeId.equals(storeDB.getStoreId())) {
            throw new InvalidAttributeChangeException("Can not change store ID");
        }

        storeDB.setName(storeName);

        storeDao.saveStore(storeDB);

        StoreModel storeModel = new ModelConverter().toStoreModel(storeDB);

        return UpdateStoreResult.builder().withStore(storeModel).build();

>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f
    }
}
