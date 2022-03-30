package com.bloomshoppingcomplex.EndPoint;

import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CreateAccount_Factory implements Factory<CreateAccount> {
  private final Provider<AccountDao> accountDaoProvider;

  public CreateAccount_Factory(Provider<AccountDao> accountDaoProvider) {
    this.accountDaoProvider = accountDaoProvider;
  }

  @Override
  public CreateAccount get() {
    return new CreateAccount(accountDaoProvider.get());
  }

  public static CreateAccount_Factory create(Provider<AccountDao> accountDaoProvider) {
    return new CreateAccount_Factory(accountDaoProvider);
  }
}
