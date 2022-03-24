package com.bloomshoppingcomplex.Converter;

import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.Models.AccountModel;

import java.util.ArrayList;
import java.util.List;

public class AccountModelConverter {
    public AccountModel toAccountModel(Account account) {

        List<String> favorites = null;

        if (account.getFavorites() != null) {
            favorites = new ArrayList<>(account.getFavorites());
        }

        return AccountModel.builder()
                .withUserId(account.getUserId())
                .withName(account.getName())
                .withEmail(account.getEmail())
                .withFavorites(favorites)
                .build();
    }
}
