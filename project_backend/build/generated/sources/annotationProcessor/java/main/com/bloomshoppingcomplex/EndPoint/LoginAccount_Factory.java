package com.bloomshoppingcomplex.EndPoint;

import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LoginAccount_Factory implements Factory<LoginAccount> {
  private final Provider<AccountDao> accountDaoProvider;

  public LoginAccount_Factory(Provider<AccountDao> accountDaoProvider) {
    this.accountDaoProvider = accountDaoProvider;
  }

  @Override
  public LoginAccount get() {
    return newInstance(accountDaoProvider.get());
  }

  public static LoginAccount_Factory create(Provider<AccountDao> accountDaoProvider) {
    return new LoginAccount_Factory(accountDaoProvider);
  }

  public static LoginAccount newInstance(AccountDao accountDao) {
    return new LoginAccount(accountDao);
  }
}
