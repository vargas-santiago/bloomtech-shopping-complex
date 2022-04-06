package com.bloomshoppingcomplex.Models.Request;

import java.util.Objects;

public class UpdateAccountRequest {

    private String userId;
    private String password;
    private String email;

    public UpdateAccountRequest() {}

    public UpdateAccountRequest(String userId, String password, String email) {
        this.userId = userId;
        this.password = password;
        this.email = email;
    }

    public UpdateAccountRequest(Builder builder) {
        this.userId = builder.userId;
        this.password = builder.password;
        this.email = builder.email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateAccountRequest)) return false;
        UpdateAccountRequest that = (UpdateAccountRequest) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getPassword(), getEmail());
    }

    @Override
    public String toString() {
        return "UpdateAccountRequest{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String userId;
        private String password;
        private String email;

        private Builder() {}

        public Builder withUserId(String userIdToUse) {
            this.userId = userIdToUse;
            return this;
        }

        public Builder withPassword(String passwordToUse) {
            this.password = passwordToUse;
            return this;
        }

        public Builder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }

        public UpdateAccountRequest build() {
            return new UpdateAccountRequest(this);
        }
    }
}
