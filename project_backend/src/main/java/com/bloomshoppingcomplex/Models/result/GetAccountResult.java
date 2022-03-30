package com.bloomshoppingcomplex.Models.result;

import com.bloomshoppingcomplex.Models.AccountModel;

public class GetAccountResult {
    private AccountModel accountModel;

    public GetAccountResult(Builder builder) {
        this.accountModel = builder.accountModel;
    }

    public AccountModel getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(AccountModel accountModel) {
        this.accountModel = accountModel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private AccountModel accountModel;

        public Builder withAccountModel(AccountModel accountModel) {
            this.accountModel = accountModel;
            return this;
        }

        public GetAccountResult build() {
            return new GetAccountResult(this);
        }
    }
}
