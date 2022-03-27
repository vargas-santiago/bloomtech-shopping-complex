package com.bloomshoppingcomplex.DynamoDB.Models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.List;

@DynamoDBTable(tableName = "stores")
public class Store {
    public static final String STORE_NAME_INDEX = "StoreNameIndex";
    public static final String STORE_CATEGORY_INDEX = "StoreCategoryIndex";

    private String storeId;
    private String name;
    private List<String> items;
    private List<String> categories;
    private int popularity;


    @DynamoDBHashKey(attributeName = "storeId")
    public String getStoreId() {
        return storeId;
    }
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }


    @DynamoDBAttribute(attributeName = "name")
    @DynamoDBIndexHashKey(globalSecondaryIndexName = STORE_NAME_INDEX, attributeName = "name")
    @DynamoDBIndexRangeKey(globalSecondaryIndexName = STORE_NAME_INDEX, attributeName = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @DynamoDBAttribute(attributeName = "items")
    public List<String> getItems() {
        return items;
    }
    public void setItems(List<String> items) {
        this.items = items;
    }


    @DynamoDBAttribute(attributeName = "categories")
    @DynamoDBIndexHashKey(globalSecondaryIndexName = STORE_CATEGORY_INDEX, attributeName = "categories")
    public List<String> getCategories() {
        return categories;
    }
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }


    @DynamoDBAttribute(attributeName = "popularity")
    public int getPopularity() {
        return popularity;
    }
    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

}