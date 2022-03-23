package main.java.com.bloomshoppingcomplex.DynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class AccountDao {
    private final DynamoDBMapper dynamoDbMapper;

    public AccountDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    /**
     * Returns the {@link AccountTable} corresponding to the specified id.
     *
     * @param userId for the Account
     * @return the stored account, or null if none was found.
     */
    public AccountTable getAccount(String userId) {
        AccountTable account = this.dynamoDbMapper.load(AccountTable.class, userId);

        if (account == null) {
            throw new IllegalArgumentException();
        }
        return account;
    }

    public AccountTable saveAccount(AccountTable account) {
        this.dynamoDbMapper.save(account);
        return account;
    }
}