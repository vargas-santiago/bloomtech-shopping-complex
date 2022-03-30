package com.bloomshoppingcomplex.Helpers;

import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.Util.AccountUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class AccountHelper {

    public static List<Account> generateAccountList(int amountOfAccounts, int amountOfFavorites) {
        List<Account> accountList = new ArrayList<>();

        for (int i = 0; i < amountOfAccounts; i++) {
            Account account = new Account();
            account.setUserId(AccountUtils.generateUserId());
            account.setUsername("userName" + i);
            account.setEmail("user" + i + "@email.com");
            account.setPassword(RandomStringUtils.randomAlphanumeric(10));

            List<String> favorites = new ArrayList<>();
            for (int j = 0; j < amountOfFavorites; j++) {
                favorites.add("favorite" + j);
            }

            account.setFavorites(favorites);
            accountList.add(account);
        }

        return accountList;
    }
}
