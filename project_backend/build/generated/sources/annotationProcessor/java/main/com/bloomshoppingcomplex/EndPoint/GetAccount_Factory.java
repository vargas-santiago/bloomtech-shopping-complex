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
public final class GetAccount_Factory implements Factory<GetAccount> {
  private final Provider<AccountDao> accountDaoProvider;

  public GetAccount_Factory(Provider<AccountDao> accountDaoProvider) {
    this.accountDaoProvider = accountDaoProvider;
  }

  @Override
  public GetAccount get() {
    return newInstance(accountDaoProvider.get());
  }

  public static GetAccount_Factory create(Provider<AccountDao> accountDaoProvider) {
    return new GetAccount_Factory(accountDaoProvider);
  }

  public static GetAccount newInstance(AccountDao accountDao) {
    return new GetAccount(accountDao);
  }
}
