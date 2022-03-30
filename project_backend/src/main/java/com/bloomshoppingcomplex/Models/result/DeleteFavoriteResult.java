package com.bloomshoppingcomplex.Models.result;


import com.bloomshoppingcomplex.Models.AccountModel;

public class DeleteFavoriteResult {
    private AccountModel account;

    public DeleteFavoriteResult(Builder builder) {
        this.account = builder.account;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private AccountModel account;

        public Builder withAccount(AccountModel account) {
            this.account = account;
            return this;
        }

        public DeleteFavoriteResult build() {
            return new DeleteFavoriteResult(this);
        }
    }
}