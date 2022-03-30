package com.bloomshoppingcomplex.Helpers;

import com.bloomshoppingcomplex.DynamoDB.Models.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreHelper {

    public static List<Store> generateStoreList(int amountOfStores, int amountOfItemsInStores) {
        List<Store> storeList = new ArrayList<>();

        for (int i = 0; i < amountOfStores; i++) {
            Store store = new Store();
            store.setStoreId("storeId" + i);
            store.setName("storeName" + i);
            store.setPopularity(i + 10);

            List<String> items = new ArrayList<>();
            for (int j = 0; j < amountOfItemsInStores; j++) {
                items.add("item" + j);
            }
            store.setItems(items);

            List<String> categories = new ArrayList<>();

            categories.add("category" + i);

            if (i % 2 == 0) {
                categories.add("category" + i);
            }

            store.setCategories(categories);

            storeList.add(store);
        }

        return storeList;
    }
}
