package main.java.com.bloomshoppingcomplex.TableModel.result;


import main.java.com.bloomshoppingcomplex.Models.AccountModel;

public class CreateAccountResult {
    private AccountModel account;

    public CreateAccountResult(Builder builder) {
        this.account = builder.account;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }
}
