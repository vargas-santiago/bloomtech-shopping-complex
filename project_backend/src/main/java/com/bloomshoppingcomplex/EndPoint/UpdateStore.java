package com.bloomshoppingcomplex.EndPoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Converter.ModelConverter;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import com.bloomshoppingcomplex.Exceptions.InvalidAttributeChangeException;
import com.bloomshoppingcomplex.Exceptions.InvalidCharacterException;
import com.bloomshoppingcomplex.Exceptions.StoreNotFoundException;
import com.bloomshoppingcomplex.Models.Request.UpdateStoreRequest;
import com.bloomshoppingcomplex.Models.StoreModel;
import com.bloomshoppingcomplex.Models.result.UpdateStoreResult;
import com.bloomshoppingcomplex.Util.StoreUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.management.InvalidAttributeValueException;
import java.util.List;

public class UpdateStore implements RequestHandler<UpdateStoreRequest, UpdateStoreResult> {
    private final Logger log = LogManager.getLogger();
    private final StoreDao storeDao;

    @Inject
    public UpdateStore(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
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

    }
}
