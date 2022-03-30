package com.bloomshoppingcomplex.Models.result;

import com.bloomshoppingcomplex.Models.AccountModel;

public class GetAccountResult {
    private AccountModel account;

    public GetAccountResult(Builder builder) {
        this.account = builder.account;
    }

    public AccountModel getAccountModel() {
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

        public Builder withAccountModel(AccountModel accountToUse) {
            this.account = accountToUse;
            return this;
        }

        public GetAccountResult build() {
            return new GetAccountResult(this);
        }
    }
}
