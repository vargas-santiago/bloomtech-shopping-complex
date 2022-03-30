package com.bloomshoppingcomplex.DynamoDB.Models;

import com.bloomshoppingcomplex.Helpers.ItemHelper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    void ItemsEqualEachOtherWhenCompared() {

        List<Item> items = ItemHelper.generateItemList(3);
        List<Item> items2 = ItemHelper.generateItemList(3);

        for (int i = 0; i < items.size(); i++) {
            boolean itemsEqual = false;

            if (items.get(i).equals(items2.get(i))) {
                itemsEqual = true;
            }

            assertTrue(itemsEqual);
        }
    }

    @Test
    void DifferentNotEqualEachOtherWhenCompared() {

        List<Item> items = ItemHelper.generateItemList(3);
        List<Item> items2 = ItemHelper.generateItemList(6);

        for (int i = 0; i < items.size(); i++) {
            boolean itemsEqual = false;

            if (items.get(i).equals(items2.get(i))) {
                itemsEqual = true;
            }

            if (i > 3) {
                assertFalse(itemsEqual);
            }
        }
    }
}
