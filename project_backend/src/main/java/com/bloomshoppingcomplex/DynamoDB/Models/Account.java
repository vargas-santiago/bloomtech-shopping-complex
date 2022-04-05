package com.bloomshoppingcomplex.DynamoDB.Models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.List;
import java.util.Objects;

@DynamoDBTable(tableName = "accounts")
public class Account {
    private String userId;
    private String password;
    private List<String> favorites;
    private String username;
    private String email;

    public static final String USERNAME_INDEX = "UsernameIndex";


    @DynamoDBHashKey(attributeName = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDBAttribute(attributeName = "password")
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @DynamoDBAttribute(attributeName = "username")
    @DynamoDBIndexHashKey(globalSecondaryIndexName = USERNAME_INDEX, attributeName="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @DynamoDBAttribute(attributeName = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBAttribute(attributeName = "favorites")
    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account that = (Account) o;
        return Objects.equals(this.getUserId(), that.getUserId()) && Objects.equals(this.getUsername(), that.getUsername()) && Objects.equals(this.getEmail(), that.getEmail()) && Objects.equals(this.getFavorites(), that.getFavorites()) && Objects.equals(this.getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername(), getEmail(), getFavorites());
    }

    @Override
    public String toString() {
        return "Account {" +
                "userId='" + userId + '\'' +
                ", favorites='" + favorites + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


