package main.java.com.bloomshoppingcomplex.TableModel.request;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class CreateAccountRequest {
    private String userId;
    private List<String> favorites;
    private String name;
    private String email;

    public CreateAccountRequest(String userId, List<String> favorites, String name, String email) {
        this.userId = userId;
        this.favorites = favorites;
        this.name = name;
        this.email = email;
    }

    public CreateAccountRequest() {}

//    public CreateAccountRequest(Build)


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
        CreateAccountRequest that = (CreateAccountRequest) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getFavorites(), that.getFavorites()) && Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFavorites(), getName(), getEmail());
    }

    @Override
    public String toString() {
        return "CreateAccountRequest{" +
                "userId='" + userId + '\'' +
                ", favorites=" + favorites +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
