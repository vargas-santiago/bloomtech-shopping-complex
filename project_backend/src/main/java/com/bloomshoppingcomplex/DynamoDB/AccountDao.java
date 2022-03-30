package com.bloomshoppingcomplex.DynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;

public class AccountDao {
    private final DynamoDBMapper dynamoDbMapper;

    public AccountDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    /**
     * Returns the {@link Account} corresponding to the specified id.
     *
     * @param userId for the Account
     * @return the stored account, or null if none was found.
     */
    public Account getAccount(String userId) {
        Account account = this.dynamoDbMapper.load(Account.class, userId);

        if (account == null) {
            throw new UserNotFoundException();
        }
        return account;
    }

    public Account saveAccount(Account account) {
        this.dynamoDbMapper.save(account);
        return account;
    }

    public Account deleteAccount(Account account) {
        this.dynamoDbMapper.delete(account);
        return account;
    }

    public boolean doesAccountExist(String userId) {
        Account account = this.dynamoDbMapper.load(Account.class, userId);

        if (account == null) {
            return false;
        }
        return true;
    }
}