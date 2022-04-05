package com.bloomshoppingcomplex.DynamoDB.Models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.List;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store that = (Store) o;
        return Objects.equals(this.getStoreId(), that.getStoreId()) && Objects.equals(this.getName(), that.getName()) && Objects.equals(this.getItems(), that.getItems()) && Objects.equals(this.getCategories(), that.getCategories()) && Objects.equals(this.getPopularity(), that.getPopularity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStoreId(), getName(), getItems(), getCategories(), getPopularity());
    }

    @Override
    public String toString() {
        return "Account {" +
                "storeId='" + storeId + '\'' +
                ", name='" + name + '\'' +
                ", items='" + items + '\'' +
                ", categories='" + categories + '\'' +
                ", popularity='" + popularity + '\'' +
                '}';
    }
}