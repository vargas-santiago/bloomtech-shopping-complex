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
import com.bloomshoppingcomplex.Models.Request.DeleteFavoriteRequest;
import com.bloomshoppingcomplex.Models.result.AddFavoriteResult;
import com.bloomshoppingcomplex.Models.result.DeleteFavoriteResult;
import com.bloomshoppingcomplex.Util.AccountUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class DeleteFavorite implements RequestHandler<DeleteFavoriteRequest, DeleteFavoriteResult> {
    private final Logger log = LogManager.getLogger();
    private final AccountDao accountDao;
    private final StoreDao storeDao;

    public DeleteFavorite(AccountDao accountDao, StoreDao storeDao) {
        this.accountDao = accountDao;
        this.storeDao = storeDao;
    }

    public DeleteFavoriteResult handleRequest(final DeleteFavoriteRequest deleteFavoriteRequest, Context context) {
        log.info("Received DeleteFavoriteRequest {}", deleteFavoriteRequest);

        Account account = accountDao.getAccount(deleteFavoriteRequest.getUserId());

        if (account == null) {
            throw new UserNotFoundException();
        }

        if (storeDao.getStore(deleteFavoriteRequest.getFavorite()) == null) {
            throw new StoreNotFoundException();
        }

        List<String> newFavorites = account.getFavorites();

        newFavorites.remove(deleteFavoriteRequest.getFavorite());
        account.setFavorites(newFavorites);

        this.accountDao.saveAccount(account);

        AccountModel accountModel = new ModelConverter().toAccountModel(account);

        return DeleteFavoriteResult.builder()
                .withAccount(accountModel)
                .build();
    }
}