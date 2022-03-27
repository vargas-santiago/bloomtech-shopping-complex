package com.bloomshoppingcomplex.EndPoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;
import com.bloomshoppingcomplex.Models.AccountModel;
import com.bloomshoppingcomplex.Request.GetAccountRequest;
import com.bloomshoppingcomplex.Request.result.GetAccountResult;

public class GetAccount implements RequestHandler<GetAccountRequest, GetAccountResult> {
    private final AccountDao accountDao;


    public GetAccount(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public GetAccountResult handleRequest(GetAccountRequest getAccountRequest, Context context) {

        if (getAccountRequest.getUserId() == null) {
            throw new UserNotFoundException();
        }

        String requestId = getAccountRequest.getUserId();
        Account account = accountDao.getAccount(requestId);
        AccountModel accountModel = new AccountModelConverter().toAccountModel(account);

        return GetAccountResult.builder()
                .withAccount(accountModel)
                .build();
    }
}
