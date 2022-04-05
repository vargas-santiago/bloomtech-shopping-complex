package com.bloomshoppingcomplex.EndPoint;

import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
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
public final class AddFavorite_Factory implements Factory<AddFavorite> {
  private final Provider<AccountDao> accountDaoProvider;

  private final Provider<StoreDao> storeDaoProvider;

  public AddFavorite_Factory(Provider<AccountDao> accountDaoProvider,
      Provider<StoreDao> storeDaoProvider) {
    this.accountDaoProvider = accountDaoProvider;
    this.storeDaoProvider = storeDaoProvider;
  }

  @Override
  public AddFavorite get() {
    return newInstance(accountDaoProvider.get(), storeDaoProvider.get());
  }

  public static AddFavorite_Factory create(Provider<AccountDao> accountDaoProvider,
      Provider<StoreDao> storeDaoProvider) {
    return new AddFavorite_Factory(accountDaoProvider, storeDaoProvider);
  }

  public static AddFavorite newInstance(AccountDao accountDao, StoreDao storeDao) {
    return new AddFavorite(accountDao, storeDao);
  }
}
