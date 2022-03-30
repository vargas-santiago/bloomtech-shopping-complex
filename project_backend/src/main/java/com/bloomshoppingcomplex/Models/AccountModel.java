package com.bloomshoppingcomplex.Models;

import com.bloomshoppingcomplex.DynamoDB.Models.Account;

import java.util.List;
import java.util.Objects;

public class AccountModel {
    private String userId;
    private List<String> favorites;
    private String username;
    private String password;
    private String email;

    public AccountModel() {}

    public AccountModel(Builder builder) {
        this.userId = builder.userId;
        this.favorites = builder.favorites;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
    }

    public Account toAccount() {
        Account account = new Account();
        account.setUserId(this.userId);
        account.setFavorites(this.favorites);
        account.setUsername(this.username);
        account.setEmail(this.email);

        return account;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountModel)) return false;
        AccountModel that = (AccountModel) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getFavorites(), that.getFavorites()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFavorites(), getUsername(), getPassword(), getEmail());
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "userId='" + userId + '\'' +
                ", favorites=" + favorites +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String userId;
        private List<String> favorites;
        private String username;
        private String password;
        private String email;

        public Builder withUserId(String userIdToUse) {
            this.userId = userIdToUse;
            return this;
        }

        public Builder withFavorites(List<String> favoritesToUse) {
            this.favorites = favoritesToUse;
            return this;
        }

        public Builder withUsername(String usernameToUse) {
            this.username = usernameToUse;
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

        public AccountModel build() {
            return new AccountModel(this);
        }
    }
}
