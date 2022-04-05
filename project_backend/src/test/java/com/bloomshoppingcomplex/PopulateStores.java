package com.bloomshoppingcomplex;

import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import com.bloomshoppingcomplex.EndPoint.LoginAccount;
import com.bloomshoppingcomplex.Models.Request.LoginAccountRequest;
import com.bloomshoppingcomplex.Models.result.LoginAccountResult;
import com.bloomshoppingcomplex.Util.StoreUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopulateStores {
    private DynamoDBMapper mapper;
    private StoreDao storeDao;
    private AccountDao accountDao;
    private AmazonDynamoDB client;
    private DynamoDBMapperConfig mapperConfig;

    @BeforeEach
    void initDao() {
        mapper = new DynamoDBMapper(client);
        storeDao = new StoreDao(mapper);
        accountDao = new AccountDao(mapper);
    }
    @BeforeEach
    void initAWS() {
        client = DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_2);
    }

    @Test
    void test() {
        LoginAccount loginAccount = new LoginAccount(accountDao);
        LoginAccountRequest loginAccountRequest = LoginAccountRequest.builder()
                .withUsername("name")
                .withPassword("passowrdl")
                .build();
        LoginAccountResult loginAccountResult = loginAccount.handleRequest(loginAccountRequest, null);
        System.out.println(loginAccountResult.getAccountModel());
    }

    @Test
    void StoresTable () {
        List<String> storeNames = new ArrayList<>();
        storeNames.add("Abercrombie & Fitch");
        storeNames.add("American Eagle Outfitter's");
        storeNames.add("Barnes & Noble");
        storeNames.add("Bath & Body Works");
        storeNames.add("Foot Locker");
        storeNames.add("General Nutrition Center");
        storeNames.add("Hollister");
        storeNames.add("Journey's");
        storeNames.add("Kay Jewelers");
        storeNames.add("L.A. Nails");
        storeNames.add("Legacy Toys");
        storeNames.add("The Lego Store");
        storeNames.add("Lids");
        storeNames.add("Lovesac");
        storeNames.add("Nike");
        storeNames.add("The North Face");
        storeNames.add("Old Navy");
        storeNames.add("Pandora");
        storeNames.add("Piercing Pagoda");
        storeNames.add("Pink");
        storeNames.add("Sephora");
        storeNames.add("Sleep Number");
        storeNames.add("Spencer's");
        storeNames.add("T-Mobile");
        storeNames.add("Verizon");
        storeNames.add("Yankee Candle");
        storeNames.add("Zales");

        List<List<String>> categories = new ArrayList<>();
        categories.add(Arrays.asList("women's apparel", "men's apparel", "children's apparel"));
        categories.add(Arrays.asList("women's apparel", "men's apparel"));
        categories.add(Arrays.asList("bookstore"));
        categories.add(Arrays.asList("health and beauty"));
        categories.add(Arrays.asList("shoes"));
        categories.add(Arrays.asList("health and beauty"));
        categories.add(Arrays.asList("women's apparel", "men's apparel"));
        categories.add(Arrays.asList("shoes"));
        categories.add(Arrays.asList("jewelry"));
        categories.add(Arrays.asList("health and beauty"));
        categories.add(Arrays.asList("toys, games, and hobbies"));
        categories.add(Arrays.asList("toys, games, and hobbies"));
        categories.add(Arrays.asList("hats and accessories"));
        categories.add(Arrays.asList("furniture"));
        categories.add(Arrays.asList("shoes"));
        categories.add(Arrays.asList("women's apparel", "men's apparel", "children's apparel"));
        categories.add(Arrays.asList("women's apparel", "men's apparel", "children's apparel"));
        categories.add(Arrays.asList("jewelry"));
        categories.add(Arrays.asList("jewelry"));
        categories.add(Arrays.asList("women's apparel"));
        categories.add(Arrays.asList("health and beauty"));
        categories.add(Arrays.asList("furniture"));
        categories.add(Arrays.asList("home"));
        categories.add(Arrays.asList("electronics and tech"));
        categories.add(Arrays.asList("electronics and tech"));
        categories.add(Arrays.asList("home"));
        categories.add(Arrays.asList("jewelry"));

        for(int i = 0; i < categories.size(); i++) {
            Store store = new Store();
            String storeId = StoreUtils.generateStoreId();

//            while(storeDao.getStore(storeId) != null){
//                storeId = StoreUtils.generateStoreId();
//            }

            store.setStoreId(storeId);
            store.setCategories(categories.get(i));
            store.setName(storeNames.get(i));
            store.setPopularity(0);
            store.setItems(new ArrayList<>());
            storeDao.saveStore(store);
        }




    }

}
