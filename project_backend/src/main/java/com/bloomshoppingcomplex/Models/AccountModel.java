package com.bloomshoppingcomplex.Models;

import com.bloomshoppingcomplex.DynamoDB.Models.Account;

import java.util.List;
import java.util.Objects;

public class AccountModel {
    private String userId;
    private List<String> favorites;
    private String name;
    private String email;

    public AccountModel() {}

    public AccountModel(Builder builder) {
        this.userId = builder.userId;
        this.favorites = builder.favorites;
        this.name = builder.name;
        this.email = builder.email;
    }

    public Account toAccount() {
        Account account = new Account();
        account.setUserId(this.userId);
        account.setFavorites(this.favorites);
        account.setName(this.name);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (o == null || getClass() != o.getClass()) return false;
        AccountModel that = (AccountModel) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getFavorites(), that.getFavorites()) && Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFavorites(), getName(), getEmail());
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "userId='" + userId + '\'' +
                ", favorites=" + favorites +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String userId;
        private List<String> favorites;
        private String name;
        private String email;

        public Builder withUserId(String userIdToUse) {
            this.userId = userIdToUse;
            return this;
        }

        public Builder withFavorites(List<String> favoritesToUse) {
            this.favorites = favoritesToUse;
            return this;
        }

        public Builder withName(String nameToUse) {
            this.name = nameToUse;
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
