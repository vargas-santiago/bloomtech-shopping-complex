package com.bloomshoppingcomplex.Request.result;

import com.bloomshoppingcomplex.Models.AccountModel;

public class UpdateAccountResult {
    private AccountModel account;

    public UpdateAccountResult(Builder builder) {
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

        public Builder withAccount(AccountModel accountToUse) {
            this.account = accountToUse;
            return this;
        }

        public UpdateAccountResult build() {
            return new UpdateAccountResult(this);
        }
    }
}
