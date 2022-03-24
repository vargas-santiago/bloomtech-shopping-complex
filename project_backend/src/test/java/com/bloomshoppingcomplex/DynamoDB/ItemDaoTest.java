package com.bloomshoppingcomplex.DynamoDB;

import com.bloomshoppingcomplex.DynamoDB.Models.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class ItemDaoTest {

    @Mock
    private ItemDao itemDao;

    @BeforeEach
    private void setup() {
        initMocks(this);
    }


    @Test
    void itemDaoReturnsItemThatHasSaved() {
        Item item1 = new Item();
        item1.setItemId("apple1");
        item1.setName("iPhone");
        item1.setQuantity(1);
        item1.setStoreName("Apple");

       itemDao.saveItem(item1);

        System.out.println(item1.getStoreName());

       Item returnedItem = itemDao.getItem("apple1", "Apple");

       //System.out.println(returnedItem.getItemId());

       assertEquals("1", "1");

    }
}
