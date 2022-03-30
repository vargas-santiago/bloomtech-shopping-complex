package com.bloomshoppingcomplex.Converter;

import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.DynamoDB.Models.Store;
import com.bloomshoppingcomplex.Models.AccountModel;
import com.beust.jcommander.internal.Lists;
import com.bloomshoppingcomplex.Models.StoreModel;

import java.util.ArrayList;
import java.util.List;

public class ModelConverter {
    public AccountModel toAccountModel(Account account) {

        List<String> favorites = new ArrayList<>();

        if (account.getFavorites() == null) {
            favorites = null;
        } else {
            favorites = Lists.newArrayList(favorites);
        }

        return AccountModel.builder()
                .withUserId(account.getUserId())
                .withName(account.getName())
                .withEmail(account.getEmail())
                .withFavorites(favorites)
                .build();
    }

    public StoreModel toStoreModel (Store store) {
        List<String> categories = new ArrayList<>();

        if (store.getCategories() == null) {
            categories = null;
        } else {
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
