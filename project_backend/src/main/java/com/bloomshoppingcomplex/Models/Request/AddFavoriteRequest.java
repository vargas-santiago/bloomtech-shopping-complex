package com.bloomshoppingcomplex.Models.Request;

import java.util.Objects;

public class AddFavoriteRequest {
    private String userId;
    private String storeId;

    public AddFavoriteRequest(String userId, String storeId) {
        this.userId = userId;
        this.storeId = storeId;
    }

    public AddFavoriteRequest() {}

    public AddFavoriteRequest(Builder builder) {
        this.userId = builder.userId;
        this.storeId = builder.storeId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddFavoriteRequest that = (AddFavoriteRequest) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(this.getStoreId(), that.getStoreId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getStoreId());
    }

    @Override
    public String toString() {
        return "AddFavoriteRequest{" +
                "userId='" + userId + '\'' +
                ", storeId='" + storeId + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String userId;
        private String storeId;

        private Builder() {

        }

        public Builder withUserId(String userIdToUse) {
            this.userId = userIdToUse;
            return this;
        }

        public Builder withStoreId(String storeId) {
            this.storeId = storeId;
            return this;
        }

        public AddFavoriteRequest build() {
            return new AddFavoriteRequest(this);
        }
    }
}