package com.bloomshoppingcomplex.Models.Request;

import java.util.Objects;

public class LoginAccountRequest {
    private String username;
    private String password;

    public LoginAccountRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginAccountRequest() {}

    public LoginAccountRequest(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginAccountRequest)) return false;
        LoginAccountRequest that = (LoginAccountRequest) o;
        return Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword());
    }

    @Override
    public String toString() {
        return "CreateAccountRequest{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String username;
        private String password;
        private Builder() {

        }

        public Builder withUsername(String usernameToUse) {
            this.username = usernameToUse;
            return this;
        }

        public Builder withPassword(String passwordToUse) {
            this.password = passwordToUse;
            return this;
        }

        public LoginAccountRequest build() {
            return new LoginAccountRequest(this);
        }
    }
}