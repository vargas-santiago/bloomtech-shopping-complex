package com.bloomshoppingcomplex.DynamoDB.Models;

import com.bloomshoppingcomplex.Helpers.AccountHelper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void AccountsEqualEachOtherWhenCompared() {

        List<Account> accounts = AccountHelper.generateAccountList(10, 5);
        List<Account> accounts2 = AccountHelper.generateAccountList(10, 5);

        for (int i = 0; i < accounts.size(); i++) {
            accounts2.get(i).setUserId(accounts.get(i).getUserId());
        }

        for (int i = 0; i < accounts.size(); i++) {
            boolean accountsEqual = false;

            if (accounts.get(i).equals(accounts2.get(i))) {
                accountsEqual = true;
            }

            assertTrue(accountsEqual);
        }
    }

    @Test
    void AccountsNotEqualEachOtherWhenCompared() {

        List<Account> accounts = AccountHelper.generateAccountList(10, 5);
        List<Account> accounts2 = AccountHelper.generateAccountList(10, 6);

        for (int i = 0; i < accounts.size(); i++) {
            boolean accountsEqual = false;

            if (accounts.get(i).equals(accounts2.get(i))) {
                accountsEqual = true;
            }

            assertFalse(accountsEqual);
        }
    }
}
