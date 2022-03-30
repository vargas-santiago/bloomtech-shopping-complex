package com.bloomshoppingcomplex.Models.Request;

import java.util.List;
import java.util.Objects;

public class UpdateStoreRequest {
    private String storeId;
    private String name;
    private List<String> items;
<<<<<<< HEAD
    private int popularity;
    private List<String> categories;
=======
    private List<String> categories;
    private int popularity;
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f

    public UpdateStoreRequest() {
    }

<<<<<<< HEAD
=======
    public UpdateStoreRequest(String storeId, String name, List<String> items, List<String> categories, int popularity) {
        this.storeId = storeId;
        this.name = name;
        this.items = items;
        this.categories = categories;
        this.popularity = popularity;
    }

>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f
    public UpdateStoreRequest(Builder builder) {
        this.storeId = builder.storeId;
        this.name = builder.name;
        this.items = builder.items;
<<<<<<< HEAD
        this.popularity = builder.popularity;
        this.categories = builder.categories;
    }

    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getItems() { return items; }
    public void setItems(List<String> items) { this.items = items; }

    public int getPopularity() { return popularity; }
    public void setPopularity(int popularity) { this.popularity = popularity; }

    public List<String> getCategory() { return categories; }
    public void setCategory(List<String> category) { this.categories = categories; }
=======
        this.categories = builder.categories;
        this.popularity = builder.popularity;
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
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateStoreRequest)) return false;
        UpdateStoreRequest that = (UpdateStoreRequest) o;
<<<<<<< HEAD
        return Objects.equals(getStoreId(), that.getStoreId());
=======
        return getPopularity() == that.getPopularity() && Objects.equals(getStoreId(), that.getStoreId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getItems(), that.getItems()) && Objects.equals(getCategories(), that.getCategories());
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return Objects.hash(getStoreId());
=======
        return Objects.hash(getStoreId(), getName(), getItems(), getCategories(), getPopularity());
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "UpdateStoreInfoRequest{" +
                "storeId='" + storeId + '\'' +
=======
        return "UpdateStoreRequest{" +
                "storeId='" + storeId + '\'' +
                ", name='" + name + '\'' +
                ", items=" + items +
                ", categories=" + categories +
                ", popularity=" + popularity +
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String storeId;
        private String name;
        private List<String> items;
<<<<<<< HEAD
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
=======
        private List<String> categories;
        private int popularity;

        private Builder() {

        }

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
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f
            return this;
        }

        public UpdateStoreRequest build() { return new UpdateStoreRequest(this); }
    }
}
