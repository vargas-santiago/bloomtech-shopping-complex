package com.bloomshoppingcomplex.Models.Request;

import java.util.Objects;

public class DeleteFavoriteRequest {
    private String userId;
    private String storeId;

    public DeleteFavoriteRequest(String userId, String storeId) {
        this.userId = userId;
        this.storeId = storeId;
    }

    public DeleteFavoriteRequest() {}

    public DeleteFavoriteRequest(Builder builder) {
        this.userId = builder.userId;
        this.storeId = builder.storeId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getFavorite() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteFavoriteRequest that = (DeleteFavoriteRequest) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(this.getFavorite(), that.getFavorite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFavorite());
    }

    @Override
    public String toString() {
        return "DeleteFavoritesRequest{" +
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

        public DeleteFavoriteRequest build() {
            return new DeleteFavoriteRequest(this);
        }
    }
}