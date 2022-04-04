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
public final class UpdateAccount_Factory implements Factory<UpdateAccount> {
  private final Provider<AccountDao> accountDaoProvider;

  public UpdateAccount_Factory(Provider<AccountDao> accountDaoProvider) {
    this.accountDaoProvider = accountDaoProvider;
  }

  @Override
  public UpdateAccount get() {
    return newInstance(accountDaoProvider.get());
  }

  public static UpdateAccount_Factory create(Provider<AccountDao> accountDaoProvider) {
    return new UpdateAccount_Factory(accountDaoProvider);
  }

  public static UpdateAccount newInstance(AccountDao accountDao) {
    return new UpdateAccount(accountDao);
  }
}
