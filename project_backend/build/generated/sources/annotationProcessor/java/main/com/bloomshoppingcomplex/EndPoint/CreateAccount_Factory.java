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
public final class CreateAccount_Factory implements Factory<CreateAccount> {
  private final Provider<AccountDao> accountDaoProvider;

  public CreateAccount_Factory(Provider<AccountDao> accountDaoProvider) {
    this.accountDaoProvider = accountDaoProvider;
  }

  @Override
  public CreateAccount get() {
    return newInstance(accountDaoProvider.get());
  }

  public static CreateAccount_Factory create(Provider<AccountDao> accountDaoProvider) {
    return new CreateAccount_Factory(accountDaoProvider);
  }

  public static CreateAccount newInstance(AccountDao accountDao) {
    return new CreateAccount(accountDao);
  }
}
