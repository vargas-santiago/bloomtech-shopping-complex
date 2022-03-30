package com.bloomshoppingcomplex.DynamoDB.Models;

import com.bloomshoppingcomplex.Helpers.ItemHelper;
import com.bloomshoppingcomplex.Helpers.StoreHelper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {

    @Test
    void SameStoresEqualEachOtherWhenCompared() {

        List<Store> stores = StoreHelper.generateStoreList(10, 5);
        List<Store> stores2 = StoreHelper.generateStoreList(10, 5);

        for (int i = 0; i < stores.size(); i++) {
            boolean storesEqual = false;

            if (stores.get(i).equals(stores2.get(i))) {
                storesEqual = true;
            }

            assertTrue(storesEqual);
        }
    }

    @Test
    void DifferentStoresNotEqualEachOtherWhenCompared() {

        List<Store> stores = StoreHelper.generateStoreList(10, 5);
        List<Store> stores2 = StoreHelper.generateStoreList(10, 4);

        for (int i = 0; i < stores.size(); i++) {
            boolean storesEqual = false;

            if (stores.get(i).equals(stores2.get(i))) {
                storesEqual = true;
            }

            assertFalse(storesEqual);
        }
    }
}
