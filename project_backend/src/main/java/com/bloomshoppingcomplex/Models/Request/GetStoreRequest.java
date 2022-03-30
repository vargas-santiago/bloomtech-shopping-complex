package com.bloomshoppingcomplex.Models.Request;

import java.util.Objects;

public class GetStoreRequest {
    private String storeId;

    public GetStoreRequest() {

    }

    public GetStoreRequest(Builder builder) {
        this.storeId = builder.storeId;
    }

    public String getStoreId() { return storeId; }

    public void setStoreId(String storeId) { this.storeId = storeId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetStoreRequest)) return false;
        GetStoreRequest that = (GetStoreRequest) o;
        return Objects.equals(getStoreId(), that.getStoreId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStoreId());
    }

    @Override
    public String toString() {
        return "GetStoreRequest{" +
                "storeId='" + storeId + '\'' +
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String storeId;

        private Builder() {

        }

        public Builder withStoreId(String storeIdToUse) {
            this.storeId = storeIdToUse;
            return this;
        }

        public GetStoreRequest build() { return new GetStoreRequest(this); }
    }
}
