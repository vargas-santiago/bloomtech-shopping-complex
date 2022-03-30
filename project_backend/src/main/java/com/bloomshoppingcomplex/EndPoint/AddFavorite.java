package com.bloomshoppingcomplex.EndPoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Converter.ModelConverter;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import com.bloomshoppingcomplex.Exceptions.StoreNotFoundException;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;
import com.bloomshoppingcomplex.Models.AccountModel;
import com.bloomshoppingcomplex.Models.Request.AddFavoriteRequest;
import com.bloomshoppingcomplex.Models.result.AddFavoriteResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AddFavorite implements RequestHandler<AddFavoriteRequest, AddFavoriteResult> {
    private final Logger log = LogManager.getLogger();
    private final AccountDao accountDao;
    private final StoreDao storeDao;

    @Inject
    public AddFavorite(AccountDao accountDao, StoreDao storeDao) {
        this.accountDao = accountDao;
        this.storeDao = storeDao;
    }

    @Override
    public AddFavoriteResult handleRequest(final AddFavoriteRequest addFavoriteRequest, Context context) {
        log.info("Received AddFavoritesRequest {}", addFavoriteRequest);

        Account account = accountDao.getAccount(addFavoriteRequest.getUserId());

        if (account == null) {
            throw new UserNotFoundException();
        }

        if (storeDao.getStore(addFavoriteRequest.getStoreId()) == null) {
            throw new StoreNotFoundException();
        }

        List<String> newFavorites = new ArrayList<>();
        if (account.getFavorites() != null) {
            newFavorites = account.getFavorites();
        }


        newFavorites.add(addFavoriteRequest.getStoreId());
        account.setFavorites(newFavorites);

        this.accountDao.saveAccount(account);

        AccountModel accountModel = new ModelConverter().toAccountModel(account);

        return AddFavoriteResult.builder()
                .withAccountModel(accountModel)
                .build();
    }
}