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
import com.bloomshoppingcomplex.Helpers.AccountHelper;
import com.bloomshoppingcomplex.Models.Request.CreateAccountRequest;
import com.bloomshoppingcomplex.Models.result.CreateAccountResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreateAccountTest {

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
    void CreateAccountAndSavesProperly() {
        List<Account> accounts = AccountHelper.generateAccountList(5, 0);
        List<CreateAccountRequest> createAccountRequests = new ArrayList<>();
        CreateAccount createAccount = new CreateAccount(accountDao);

        //Makes the requests
        for (Account account : accounts) {
            CreateAccountRequest request = new CreateAccountRequest().builder()
                    .withUserId(account.getUserId())
                    .withEmail(account.getEmail())
                    .withUsername(account.getUsername())
                    .withPassword(account.getPassword())
                    .build();

            createAccountRequests.add(request);
        }

        for (int i = 0; i < createAccountRequests.size(); i++) {
            boolean accountCreated = false;
            CreateAccountResult createAccountResult = createAccount.handleRequest(createAccountRequests.get(i), null);

            if (accountDao.getAccount(createAccountResult.getAccountModel().getUserId()) != null) {
                accountCreated = true;
            }

            assertTrue(accountCreated);
        }
    }

    @Test
    void CreateAccountWithInvalidUserIdThrowsException() {
        List<Account> accounts = AccountHelper.generateAccountList(5, 0);
        List<CreateAccountRequest> createAccountRequests = new ArrayList<>();
        CreateAccount createAccount = new CreateAccount(accountDao);

        //Makes the requests
        for (Account account : accounts) {
            CreateAccountRequest request = new CreateAccountRequest().builder()
                    .withUserId("'")
                    .withEmail(account.getEmail())
                    .withUsername(account.getUsername())
                    .build();

            createAccountRequests.add(request);
        }

        for (CreateAccountRequest createAccountRequest : createAccountRequests) {
            assertThrows(InvalidCharacterException.class, () -> createAccount.handleRequest(createAccountRequest, null));
        }
    }

    @Test
    void CreateAccountWithInvalidNameThrowsException() {
        List<Account> accounts = AccountHelper.generateAccountList(5, 0);
        List<CreateAccountRequest> createAccountRequests = new ArrayList<>();
        CreateAccount createAccount = new CreateAccount(accountDao);

        //Makes the requests
        for (Account account : accounts) {
            CreateAccountRequest request = new CreateAccountRequest().builder()
                    .withUserId(account.getUserId())
                    .withEmail(account.getEmail())
                    .withUsername("'")
                    .build();

            createAccountRequests.add(request);
        }

        for (CreateAccountRequest createAccountRequest : createAccountRequests) {
            assertThrows(InvalidCharacterException.class, () -> createAccount.handleRequest(createAccountRequest, null));
        }
    }
}
