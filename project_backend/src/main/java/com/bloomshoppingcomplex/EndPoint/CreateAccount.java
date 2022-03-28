package com.bloomshoppingcomplex.EndPoint;

import com.bloomshoppingcomplex.Converter.ModelConverter;
import com.bloomshoppingcomplex.Exceptions.InvalidCharacterException;
import com.bloomshoppingcomplex.Models.AccountModel;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.Models.Request.CreateAccountRequest;
import com.bloomshoppingcomplex.Models.result.CreateAccountResult;
import com.bloomshoppingcomplex.Util.AccountUtils;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.ArrayList;


public class CreateAccount implements RequestHandler<CreateAccountRequest, CreateAccountResult> {
    private final Logger log = LogManager.getLogger();
    private final AccountDao accountDao;

    @Inject
    public CreateAccount(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public CreateAccountResult handleRequest(final CreateAccountRequest createAccountRequest, Context context) {
        log.info("Received CreateAccountRequest {}", createAccountRequest);

        if (!AccountUtils.isValidString(createAccountRequest.getUserId())) {
            throw new InvalidCharacterException();
        }

        if (!AccountUtils.isValidString(createAccountRequest.getName())) {
            throw new InvalidCharacterException();
        }

        Account newAccount = new Account();

        newAccount.setUserId(AccountUtils.generateUserId());
        newAccount.setName(createAccountRequest.getName());
        newAccount.setEmail(createAccountRequest.getEmail());
        newAccount.setFavorites(new ArrayList<>());

        this.accountDao.saveAccount(newAccount);

        AccountModel accountModel = new ModelConverter().toAccountModel(newAccount);

        return CreateAccountResult.builder()
                .withAccount(accountModel)
                .build();
    }
}