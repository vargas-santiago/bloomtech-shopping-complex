package com.bloomshoppingcomplex.DynamoDB;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.DynamoDB.Models.Item;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;
import com.bloomshoppingcomplex.Helpers.AccountHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountDaoTest {

    private DynamoDBMapper mapper;
    private AccountDao accountDao;

    private AmazonDynamoDB client;
    private DynamoDBMapperConfig mapperConfig;

    @BeforeEach
    void initDao() {
        mapper = new DynamoDBMapper(client);
        accountDao = new AccountDao(mapper);
    }

    @BeforeEach
    void initAWS() {
        client = DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_1);
    }

    @AfterEach
    void cleanTables() {
        mapperConfig = new DynamoDBMapperConfig.Builder().withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement("accounts")).build();

        DynamoDBMapper mapper = new DynamoDBMapper(client, mapperConfig);
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

        List<Account> accountResult = mapper.scan(Account.class, scanExpression);

        for (Account account : accountResult) {
            accountDao.deleteAccount(account);
        }
    }
    @Test
    void accountReturnedEqualsAccountSaved() {

        List<Account> accounts = AccountHelper.generateAccountList(3, 5);

        for (Account account : accounts) {
            boolean accountsEqual = false;
            Account accountExpected = account;

            accountDao.saveAccount(account);
            Account itemReturned = accountDao.getAccount(accountExpected.getUserId());

            if (itemReturned.equals(accountExpected)) {
                accountsEqual = true;
            }
            assertTrue(accountsEqual);
        }
    }


    @Test
    void RetrievingNonExistingAccountThrowsUserNotFoundException() {

        List<Account> accounts = AccountHelper.generateAccountList(3, 5);

        for (Account account : accounts) {
            Account accountExpected = account;

            assertThrows(UserNotFoundException.class, () -> accountDao.getAccount(accountExpected.getUserId()));
        }
    }
}
