package com.bloomshoppingcomplex.EndPoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Converter.ModelConverter;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;
import com.bloomshoppingcomplex.Models.AccountModel;
import com.bloomshoppingcomplex.Models.Request.GetAccountRequest;
import com.bloomshoppingcomplex.Models.result.GetAccountResult;

import javax.inject.Inject;

public class GetAccount implements RequestHandler<GetAccountRequest, GetAccountResult> {
    private final AccountDao accountDao;

    @Inject
    public GetAccount(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public GetAccountResult handleRequest(GetAccountRequest getAccountRequest, Context context) {
        Account account = accountDao.getAccount(getAccountRequest.getUserId());

        if (getAccountRequest.getUserId() == null) {
            throw new UserNotFoundException();
        }


        AccountModel accountModel = new ModelConverter().toAccountModel(account);

        return GetAccountResult.builder()
                .withAccountModel(accountModel)
                .build();
    }
}
