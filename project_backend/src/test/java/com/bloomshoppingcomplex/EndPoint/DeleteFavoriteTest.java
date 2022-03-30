package com.bloomshoppingcomplex.EndPoint;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import com.bloomshoppingcomplex.Exceptions.StoreNotFoundException;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;
import com.bloomshoppingcomplex.Helpers.AccountHelper;
import com.bloomshoppingcomplex.Helpers.StoreHelper;
import com.bloomshoppingcomplex.Models.Request.AddFavoriteRequest;
import com.bloomshoppingcomplex.Models.Request.DeleteFavoriteRequest;
import com.bloomshoppingcomplex.Models.result.DeleteFavoriteResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteFavoriteTest {

    private DynamoDBMapper mapper;
    private AccountDao accountDao;
    private StoreDao storeDao;

    private AmazonDynamoDB client;
    private DynamoDBMapperConfig accountMapperConfig;
    private DynamoDBMapperConfig storeMapperConfig;

    @BeforeEach
    void initDao() {
        mapper = new DynamoDBMapper(client);
        accountDao = new AccountDao(mapper);
        storeDao = new StoreDao(mapper);
    }

    @BeforeEach
    void initAWS() {
        client = DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_1);
    }

    @AfterEach
    void cleanTables() {
        accountMapperConfig = new DynamoDBMapperConfig.Builder().withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement("accounts")).build();
        storeMapperConfig = new DynamoDBMapperConfig.Builder().withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement("stores")).build();

        DynamoDBMapper accountMapper = new DynamoDBMapper(client, accountMapperConfig);
        DynamoDBMapper storeMapper = new DynamoDBMapper(client, storeMapperConfig);
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

        List<Account>accountsResult = accountMapper.scan(Account.class, scanExpression);
        List<Store>storesResult = storeMapper.scan(Store.class, scanExpression);

        for (Account account : accountsResult) {
            accountDao.deleteAccount(account);
        }

        for (Store store : storesResult) {
            storeDao.deleteStore(store);
        }
    }

    @Test
    void FavoriteDeletedWithExistingUserAndStore() {
        List<Account> accounts = AccountHelper.generateAccountList(3, 3);
        List<Store> stores = StoreHelper.generateStoreList(3, 0);
        List<DeleteFavoriteRequest> deleteFavoriteRequests = new ArrayList<>();
        DeleteFavorite deleteFavorite = new DeleteFavorite(accountDao, storeDao);

        //Makes the requests
        for (Account account : accounts) {
            for (Store store : stores) {
                DeleteFavoriteRequest request = new DeleteFavoriteRequest().builder()
                        .withUserId(account.getUserId())
                        .withStoreId(store.getStoreId())
                        .build();

                deleteFavoriteRequests.add(request);
                List<String> favorites = account.getFavorites();
                favorites.add(store.getStoreId());
                account.setFavorites(favorites);
            }
        }

        //Populates account table
        for (Account account : accounts) {
            accountDao.saveAccount(account);
        }
        //Populate store table
        for (Store store : stores) {
            storeDao.saveStore(store);
        }

        for (int i = 0; i < deleteFavoriteRequests.size(); i++) {
            DeleteFavoriteResult deleteFavoriteResult = deleteFavorite.handleRequest(deleteFavoriteRequests.get(i), null);

            if (i+1 % 3 == 0) {
                boolean storesInRequestRemoved = true;
                List<String> accountSavedFavorites = accountDao.getAccount(deleteFavoriteResult.getAccount().getUserId()).getFavorites();

                if (accountSavedFavorites.contains(stores.get(0)) && accountSavedFavorites.contains(stores.get(1)) && accountSavedFavorites.contains(stores.get(2))) {
                    storesInRequestRemoved = false;
                }

                assertTrue(storesInRequestRemoved);
            }
        }
    }

    @Test
    void FavoriteDeletedWithExistingUserButNotStore() {
        List<Account> accounts = AccountHelper.generateAccountList(1, 3);
        List<Store> stores = StoreHelper.generateStoreList(1, 0);
        List<DeleteFavoriteRequest> deleteFavoriteRequests = new ArrayList<>();
        DeleteFavorite deleteFavorite = new DeleteFavorite(accountDao, storeDao);

        //Makes the requests
        for (Account account : accounts) {
            for (Store store : stores) {
                DeleteFavoriteRequest request = new DeleteFavoriteRequest().builder()
                        .withUserId(account.getUserId())
                        .withStoreId(store.getStoreId())
                        .build();

                deleteFavoriteRequests.add(request);
            }
        }

        //Populates account table
        for (Account account : accounts) {
            accountDao.saveAccount(account);
        }

        for (DeleteFavoriteRequest deleteFavoriteRequest : deleteFavoriteRequests) {
            assertThrows(StoreNotFoundException.class, () -> deleteFavorite.handleRequest(deleteFavoriteRequest, null));
        }
    }

    @Test
    void FavoriteDeletedWithExistingStoreButNotUser() {
        List<Account> accounts = AccountHelper.generateAccountList(1, 3);
        List<Store> stores = StoreHelper.generateStoreList(1, 0);
        List<DeleteFavoriteRequest> deleteFavoriteRequests = new ArrayList<>();
        DeleteFavorite deleteFavorite = new DeleteFavorite(accountDao, storeDao);

        //Makes the requests
        for (Account account : accounts) {
            for (Store store : stores) {
                DeleteFavoriteRequest request = new DeleteFavoriteRequest().builder()
                        .withUserId(account.getUserId())
                        .withStoreId(store.getStoreId())
                        .build();

                deleteFavoriteRequests.add(request);
            }
        }

        for (DeleteFavoriteRequest deleteFavoriteRequest : deleteFavoriteRequests) {
            assertThrows(UserNotFoundException.class, () -> deleteFavorite.handleRequest(deleteFavoriteRequest, null));
        }
    }

    @Test
    void EqualFavoriteRequestsEqualEachOther() {
        List<Account> accounts = AccountHelper.generateAccountList(5, 3);
        List<Store> stores = StoreHelper.generateStoreList(5, 0);
        List<DeleteFavoriteRequest> deleteFavoriteRequests = new ArrayList<>();

        List<Account> accounts2 = AccountHelper.generateAccountList(5, 3);
        List<Store> stores2 = StoreHelper.generateStoreList(5, 0);
        List<DeleteFavoriteRequest> deleteFavoriteRequests2 = new ArrayList<>();

        for (int i = 0; i < accounts.size(); i++) {
            accounts2.get(i).setUserId(accounts.get(i).getUserId());
        }

        //Makes the requests
        for (Account account : accounts) {
            for (Store store : stores) {
                DeleteFavoriteRequest request = new DeleteFavoriteRequest().builder()
                        .withUserId(account.getUserId())
                        .withStoreId(store.getStoreId())
                        .build();

                deleteFavoriteRequests.add(request);
            }
        }

        //Makes the requests
        for (Account account : accounts2) {
            for (Store store : stores2) {
                DeleteFavoriteRequest request = new DeleteFavoriteRequest().builder()
                        .withUserId(account.getUserId())
                        .withStoreId(store.getStoreId())
                        .build();

                deleteFavoriteRequests2.add(request);
            }
        }

        for (int i = 0; i < deleteFavoriteRequests.size(); i++) {
            boolean requestsEqual = false;

            if (deleteFavoriteRequests.get(i).equals(deleteFavoriteRequests2.get(i))) {
                requestsEqual = true;
            }
            assertTrue(requestsEqual);
        }
    }
}
