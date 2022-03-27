package com.bloomshoppingcomplex.Request;

import java.util.Objects;

public class GetStoreInfoRequest {
    private String storeId;

    public GetStoreInfoRequest() {

    }

    public GetStoreInfoRequest(Builder builder) { this.storeId = builder.storeId; }

    public String getStoreId() { return storeId; }

    public void setStoreId(String storeId) { this.storeId = storeId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetStoreInfoRequest)) return false;
        GetStoreInfoRequest that = (GetStoreInfoRequest) o;
        return Objects.equals(getStoreId(), that.getStoreId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStoreId());
    }

    @Override
    public String toString() {
        return "GetStoreInfoRequest{" +
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

        public GetStoreInfoRequest build() { return new GetStoreInfoRequest(this); }
    }
}
