package com.bloomshoppingcomplex.Models.Request;

import java.util.Objects;

public class CreateAccountRequest {
    private String username;
    private String password;
    private String email;

    public CreateAccountRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public CreateAccountRequest() {}

    public CreateAccountRequest(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateAccountRequest)) return false;
        CreateAccountRequest that = (CreateAccountRequest) o;
        return Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword(), getEmail());
    }

    @Override
    public String toString() {
        return "CreateAccountRequest{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String username;
        private String password;
        private String email;

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

        public Builder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }

        public CreateAccountRequest build() {
            return new CreateAccountRequest(this);
        }
    }
}