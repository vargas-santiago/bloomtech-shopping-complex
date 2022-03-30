package com.bloomshoppingcomplex.Helpers;

import com.bloomshoppingcomplex.DynamoDB.Models.Item;
import com.bloomshoppingcomplex.DynamoDB.Models.ItemTest;

import java.util.ArrayList;
import java.util.List;

public class ItemHelper {

    public static List<Item> generateItemList(int amountOfItems) {
        List<Item> itemList = new ArrayList<>();

        for (int i = 0; i < amountOfItems; i++) {
            Item item = new Item();
            item.setItemId("itemId" + i);
            item.setStoreId("storeId" + i);
            item.setName("itemName" + i);

            item.setQuantity(12);
            if (i % 2 == 0) {
                item.setQuantity(6);
            }



            itemList.add(item);
        }

        return itemList;
    }
}
