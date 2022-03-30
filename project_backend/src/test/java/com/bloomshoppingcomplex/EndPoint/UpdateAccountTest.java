package com.bloomshoppingcomplex.EndPoint;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;
import com.bloomshoppingcomplex.Helpers.AccountHelper;
import com.bloomshoppingcomplex.Models.result.UpdateAccountResult;
import com.bloomshoppingcomplex.Models.Request.UpdateAccountRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpdateAccountTest {

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
    void UpdateAccountUpdatesCorrectly() {
        List<Account> accounts = AccountHelper.generateAccountList(5, 3);
        List<Account> accounts2 = AccountHelper.generateAccountList(5, 3);
        List<UpdateAccountRequest> updateAccountRequests = new ArrayList<>();
        UpdateAccount updateAccount = new UpdateAccount(accountDao);

        for (int i = 0; i < accounts2.size(); i++) {
            accounts2.get(i).setUserId(accounts.get(i).getUserId());
            accounts2.get(i).setPassword(accounts.get(i).getPassword());
        }

        for (Account account : accounts2) {
            account.setUsername(account.getUsername() + "NEW");
            account.setEmail(account.getEmail() + "NEW");
        }

        // Populate accounts table
        for (Account account : accounts) {
            accountDao.saveAccount(account);
        }

        // Makes the requests
        for (Account account : accounts2) {
            UpdateAccountRequest request = new UpdateAccountRequest().builder()
                    .withUserId(account.getUserId())
                    .withEmail(account.getEmail())
                    .withUsername(account.getUsername())
                    .build();

            updateAccountRequests.add(request);
        }

        for (int i = 0; i < updateAccountRequests.size(); i++) {
            boolean storesUpdates = false;
            UpdateAccountResult getAccountResult = updateAccount.handleRequest(updateAccountRequests.get(i), null);

            if (accountDao.getAccount(getAccountResult.getAccountModel().getUserId()).equals(accounts2.get(i))) {
                storesUpdates = true;
            }

            assertTrue(storesUpdates);
        }
    }

    @Test
    void UpdateAccountWithNonExistingUserIdThrowsException() {
        List<Account> accounts = AccountHelper.generateAccountList(5, 3);
        List<UpdateAccountRequest> updateAccountRequests = new ArrayList<>();
        UpdateAccount updateAccount = new UpdateAccount(accountDao);

        // Makes the requests
        for (Account account : accounts) {
            UpdateAccountRequest request = new UpdateAccountRequest().builder()
                    .withUserId(account.getUserId())
                    .withEmail(account.getEmail())
                    .withUsername(account.getUsername())
                    .build();

            updateAccountRequests.add(request);
        }

        for (UpdateAccountRequest updateAccountRequest : updateAccountRequests) {
            assertThrows(UserNotFoundException.class, () -> updateAccount.handleRequest(updateAccountRequest, null));
        }
    }
}
