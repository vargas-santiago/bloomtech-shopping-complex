package com.bloomshoppingcomplex.Models;

import com.bloomshoppingcomplex.DynamoDB.Models.Store;

import java.util.List;
import java.util.Objects;

public class StoreModel {
    private String storeId;
    private String name;
    private List<String> items;
    private List<String> categories;
    private int popularity;

    public StoreModel() {

    }

    public StoreModel(Builder builder) {
        this.storeId = builder.storeId;
        this.name = builder.name;
        this.items = builder.items;
        this.categories = builder.categories;
        this.popularity = builder.popularity;
    }

    public Store toStore() {
        Store store = new Store();

        store.setStoreId(this.storeId);
        store.setName(this.name);
        store.setItems(this.items);
        store.setCategories(this.categories);
        store.setPopularity(this.popularity);

        return store;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoreModel)) return false;
        StoreModel that = (StoreModel) o;
        return getPopularity() == that.getPopularity() && Objects.equals(getStoreId(), that.getStoreId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getItems(), that.getItems()) && Objects.equals(getCategories(), that.getCategories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStoreId(), getName(), getItems(), getCategories(), getPopularity());
    }

    @Override
    public String toString() {
        return "StoreModel{" +
                "storeId='" + storeId + '\'' +
                ", name='" + name + '\'' +
                ", items=" + items +
                ", categories=" + categories +
                ", popularity=" + popularity +
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String storeId;
        private String name;
        private List<String> items;
        private List<String> categories;
        private int popularity;

        public Builder withStoreId(String storeIdToUse) {
            this.storeId = storeIdToUse;
            return this;
        }

        public Builder withName(String nameToUse) {
            this.name = nameToUse;
            return this;
        }

        public Builder withItems(List<String> itemsToUse) {
            this.items = itemsToUse;
            return this;
        }

        public Builder withCategories(List<String> categoriesToUse) {
            this.categories = categoriesToUse;
            return this;
        }

        public Builder withPopularity(int popularityToUse) {
            this.popularity = popularityToUse;
            return this;
        }

        public StoreModel build() {
            return new StoreModel(this);
        }
    }
}
