package com.bloomshoppingcomplex.EndPoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Converter.ModelConverter;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import com.bloomshoppingcomplex.Exceptions.InvalidCharacterException;
import com.bloomshoppingcomplex.Exceptions.StoreNotFoundException;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;
import com.bloomshoppingcomplex.Models.AccountModel;
import com.bloomshoppingcomplex.Models.Request.AddFavoriteRequest;
import com.bloomshoppingcomplex.Models.Request.LoginAccountRequest;
import com.bloomshoppingcomplex.Models.result.AddFavoriteResult;
import com.bloomshoppingcomplex.Models.result.LoginAccountResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class LoginAccount implements RequestHandler<LoginAccountRequest, LoginAccountResult> {
    private final Logger log = LogManager.getLogger();
    private final AccountDao accountDao;

    @Inject
    public LoginAccount(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public LoginAccountResult handleRequest(final LoginAccountRequest loginAccountRequest, Context context) {
        log.info("Received LoginAccountRequest {}", loginAccountRequest);

        Account account = accountDao.getAccount(accountDao.getUserId(loginAccountRequest.getUsername()));

        if (account == null) {
            throw new UserNotFoundException();
        }

        if (!account.getPassword().equals(loginAccountRequest.getPassword())) {
            throw new InvalidCharacterException();
        }

        AccountModel accountModel = new ModelConverter().toAccountModel(account);

        return LoginAccountResult.builder()
                .withAccountModel(accountModel)
                .build();
    }
}