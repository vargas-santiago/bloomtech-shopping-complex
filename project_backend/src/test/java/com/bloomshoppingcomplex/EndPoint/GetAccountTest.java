package com.bloomshoppingcomplex.EndPoint;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.Exceptions.InvalidCharacterException;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;
import com.bloomshoppingcomplex.Helpers.AccountHelper;
import com.bloomshoppingcomplex.Models.Request.CreateAccountRequest;
import com.bloomshoppingcomplex.Models.Request.GetAccountRequest;
import com.bloomshoppingcomplex.Models.result.GetAccountResult;
import org.apache.commons.codec.binary.BaseNCodecOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GetAccountTest {

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

        List<Account> accountsResult = mapper.scan(Account.class, scanExpression);

        for (Account account : accountsResult) {
            accountDao.deleteAccount(account);
        }
    }

    @Test
    void GetAccountGetsTheCorrectAccount() {
        List<Account> accounts = AccountHelper.generateAccountList(5, 0);
        List<GetAccountRequest> getAccountRequests = new ArrayList<>();
        GetAccount getAccount = new GetAccount(accountDao);

        //Populates account table
        for (Account account : accounts) {
            accountDao.saveAccount(account);
        }

        //Makes the requests
        for (Account account : accounts) {
            GetAccountRequest request = new GetAccountRequest().builder()
                    .withUserId(account.getUserId())
                    .build();

            getAccountRequests.add(request);
        }

        for (int i = 0; i < getAccountRequests.size(); i++) {
            boolean accountsEqual = false;
            GetAccountResult getAccountResult = getAccount.handleRequest(getAccountRequests.get(i), null);

            Account account = accounts.get(i);
            account.setPassword(null);

            if (getAccountResult.getAccountModel().toAccount().equals(accounts.get(i))) {
                accountsEqual = true;
            }

            assertTrue(accountsEqual);
        }
    }

    @Test
    void GetAccountWithNonExistingUserIdThrowsException() {
        List<Account> accounts = AccountHelper.generateAccountList(5, 0);
        List<GetAccountRequest> getAccountRequests = new ArrayList<>();
        GetAccount getAccount = new GetAccount(accountDao);

        //Makes the requests
        for (Account account : accounts) {
            GetAccountRequest request = new GetAccountRequest().builder()
                    .withUserId(account.getUserId())
                    .build();

            getAccountRequests.add(request);
        }

        for (GetAccountRequest getAccountRequest : getAccountRequests) {
            assertThrows(UserNotFoundException.class, () -> getAccount.handleRequest(getAccountRequest, null));
        }
    }
}
