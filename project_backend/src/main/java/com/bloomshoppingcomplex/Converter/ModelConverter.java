package com.bloomshoppingcomplex.Converter;

import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.Models.AccountModel;
import com.bloomshoppingcomplex.Models.StoreModel;

import java.util.List;

public class ModelConverter {
    public AccountModel toAccountModel(Account account) {

        List<String> favorites = null;

        if (account.getFavorites() != null) {
            favorites = account.getFavorites();
        }

        return AccountModel.builder()
                .withUserId(account.getUserId())
                .withUsername(account.getUsername())
                .withPassword(account.getPassword())
                .withEmail(account.getEmail())
                .withFavorites(favorites)
                .build();
    }

    public StoreModel toStoreModel (Store store) {
        List<String> categories = null;

        if (store.getCategories() != null){
            categories = store.getCategories();
        }

        return StoreModel.builder()
                .withStoreId(store.getStoreId())
                .withName(store.getName())
                .withCategories(categories)
                .withItems(store.getItems())
                .withPopularity(store.getPopularity())
                .build();
    }
}
