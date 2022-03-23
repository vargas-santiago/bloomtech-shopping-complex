package main.java.com.bloomshoppingcomplex.Models;

import java.util.List;
import java.util.Objects;

public class AccountModel {
    private String userId;
    private List<String> favorites;
    private String name;
    private String email;

    public AccountModel() {}

//    public AccountModel(Builder builder) {}


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

//    public static Builder builder() {
//        return new Builder();
//    }
}
