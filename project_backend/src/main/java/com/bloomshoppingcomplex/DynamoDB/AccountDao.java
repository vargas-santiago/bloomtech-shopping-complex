package com.bloomshoppingcomplex.DynamoDB;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class AccountDao {
    private final DynamoDBMapper dynamoDbMapper;

    @Inject
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

    public String getUserId(String username) {
        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":username", new AttributeValue().withS(username));
        DynamoDBQueryExpression<Account> queryExpression = new DynamoDBQueryExpression<Account>()
                .withIndexName("UsernameIndex")
                .withConsistentRead(false)
                .withKeyConditionExpression("username = :username")
                .withExpressionAttributeValues(valueMap);

        PaginatedQueryList<Account> userList = mapper.query(Account.class, queryExpression);

        if (userList.size() > 0) {
            return userList.get(0).getUserId();
        }
        throw new UserNotFoundException();
    }
}