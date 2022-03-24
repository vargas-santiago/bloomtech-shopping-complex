package com.bloomshoppingcomplex.Request;

import java.util.Objects;

public class GetAccountRequest {
    private String userId;

    public GetAccountRequest() {}

    public GetAccountRequest(Builder builder) {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetAccountRequest that = (GetAccountRequest) o;
        return Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }

    @Override
    public String toString() {
        return "GetAccountRequest{" +
                "userId='" + userId + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String userId;

        private Builder() {

        }

        public Builder withUserId(String userIdToUse) {
            this.userId = userIdToUse;
            return this;
        }

        public GetAccountRequest build() {
            return new GetAccountRequest(this);
        }
    }
}
