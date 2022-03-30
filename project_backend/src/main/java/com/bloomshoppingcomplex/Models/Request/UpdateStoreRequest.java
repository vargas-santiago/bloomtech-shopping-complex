package com.bloomshoppingcomplex.Models.Request;

import java.util.List;
import java.util.Objects;

public class UpdateStoreRequest {
    private String storeId;
    private String name;
    private List<String> items;
    private int popularity;
    private List<String> categories;


    public UpdateStoreRequest() {
    }

    public UpdateStoreRequest(String storeId, String name, List<String> items, List<String> categories, int popularity) {
        this.storeId = storeId;
        this.name = name;
        this.items = items;
        this.categories = categories;
        this.popularity = popularity;
    }

    public UpdateStoreRequest(Builder builder) {
        this.storeId = builder.storeId;
        this.name = builder.name;
        this.items = builder.items;
        this.popularity = builder.popularity;
        this.categories = builder.categories;
    }

    public String getStoreId() { return storeId; }

    public void setStoreId(String storeId) { this.storeId = storeId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<String> getItems() { return items; }

    public void setItems(List<String> items) { this.items = items; }

    public List<String> getCategories() { return categories; }

    public void setCategories(List<String> categories) { this.categories = categories; }

    public int getPopularity() { return popularity; }

    public void setPopularity(int popularity) { this.popularity = popularity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateStoreRequest)) return false;
        UpdateStoreRequest that = (UpdateStoreRequest) o;
        return getPopularity() == that.getPopularity() && Objects.equals(getStoreId(), that.getStoreId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getItems(), that.getItems()) && Objects.equals(getCategories(), that.getCategories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStoreId(), getName(), getItems(), getCategories(), getPopularity());
    }

    @Override
    public String toString() {
        return "UpdateStoreRequest{" +
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
        private int popularity;
        private List<String> categories;



        private Builder() {
        }

        public Builder withStoreId(String storeId) {
            this.storeId = storeId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withItems(List<String> items) {
            this.items = items;
            return this;
        }

        public Builder withPopularity(int popularity) {
            this.popularity = popularity;
            return this;
        }

        public Builder withCategories(List<String> categories) {
            this.categories = categories;
            return this;
        }

        public UpdateStoreRequest build() { return new UpdateStoreRequest(this); }
    }
}
