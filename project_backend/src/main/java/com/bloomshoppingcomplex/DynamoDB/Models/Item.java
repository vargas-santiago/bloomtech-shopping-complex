package com.bloomshoppingcomplex.DynamoDB.Models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.bloomshoppingcomplex.Models.AccountModel;

import java.util.Objects;

@DynamoDBTable(tableName = "items")
public class Item {

    private String itemId;
    private String storeId;
    private String name;
    private int quantity;


    @DynamoDBHashKey(attributeName = "itemId")
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


    @DynamoDBRangeKey(attributeName = "storeId")
    public String getStoreId() {
        return storeId;
    }
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }


    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @DynamoDBAttribute(attributeName = "quantity")
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item that = (Item) o;
        return Objects.equals(this.getItemId(), that.getItemId()) && Objects.equals(this.getStoreId(), that.getStoreId()) && Objects.equals(this.getName(), that.getName()) && Objects.equals(this.getQuantity(), that.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getStoreId(), getName(), getQuantity());
    }

}
