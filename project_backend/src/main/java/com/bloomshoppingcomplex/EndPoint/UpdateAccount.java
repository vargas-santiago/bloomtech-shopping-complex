package com.bloomshoppingcomplex.EndPoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Converter.ModelConverter;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.Exceptions.InvalidCharacterException;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;
import com.bloomshoppingcomplex.Models.AccountModel;
import com.bloomshoppingcomplex.Request.UpdateAccountRequest;
import com.bloomshoppingcomplex.Request.result.UpdateAccountResult;
import com.bloomshoppingcomplex.Util.AccountUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateAccount implements RequestHandler<UpdateAccountRequest, UpdateAccountResult> {
    private final Logger log = LogManager.getLogger();
    private final AccountDao accountDao;

    @Inject
    public UpdateAccount(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public UpdateAccountResult handleRequest(UpdateAccountRequest updateAccountRequest, Context context) {
        log.info("Received UpdatedAccountRequest {} ", updateAccountRequest);

        if (updateAccountRequest.getUserId() == null) {
            throw new UserNotFoundException();
        }

        if (!AccountUtils.isValidString(updateAccountRequest.getUserId())) {
            throw new InvalidCharacterException();
        }

        if (!AccountUtils.isValidString(updateAccountRequest.getName())) {
            throw new InvalidCharacterException();
        }

        if (!AccountUtils.isValidString(updateAccountRequest.getEmail())) {
            throw new InvalidCharacterException();
        }

        Account updateAccount = accountDao.getAccount(updateAccountRequest.getUserId());

        if (!updateAccountRequest.getUserId().equals(updateAccount.getUserId())) {
            throw new UserNotFoundException();
        }

        updateAccount.setName(updateAccountRequest.getName());
        updateAccount.setEmail(updateAccountRequest.getEmail());

        this.accountDao.saveAccount(updateAccount);

        AccountModel updatedAccount = new ModelConverter().toAccountModel(updateAccount);

        return UpdateAccountResult.builder()
                .withAccount(updatedAccount)
                .build();
    }
}
