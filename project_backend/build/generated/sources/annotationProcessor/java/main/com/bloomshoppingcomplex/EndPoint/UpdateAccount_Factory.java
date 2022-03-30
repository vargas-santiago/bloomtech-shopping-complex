package com.bloomshoppingcomplex.EndPoint;

import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UpdateAccount_Factory implements Factory<UpdateAccount> {
  private final Provider<AccountDao> accountDaoProvider;

  public UpdateAccount_Factory(Provider<AccountDao> accountDaoProvider) {
    this.accountDaoProvider = accountDaoProvider;
  }

  @Override
  public UpdateAccount get() {
    return new UpdateAccount(accountDaoProvider.get());
  }

  public static UpdateAccount_Factory create(Provider<AccountDao> accountDaoProvider) {
    return new UpdateAccount_Factory(accountDaoProvider);
  }
}
