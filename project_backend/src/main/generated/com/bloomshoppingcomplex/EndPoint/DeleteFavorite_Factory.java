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
public final class DeleteFavorite_Factory implements Factory<DeleteFavorite> {
  private final Provider<AccountDao> accountDaoProvider;

  private final Provider<StoreDao> storeDaoProvider;

  public DeleteFavorite_Factory(Provider<AccountDao> accountDaoProvider,
      Provider<StoreDao> storeDaoProvider) {
    this.accountDaoProvider = accountDaoProvider;
    this.storeDaoProvider = storeDaoProvider;
  }

  @Override
  public DeleteFavorite get() {
    return newInstance(accountDaoProvider.get(), storeDaoProvider.get());
  }

  public static DeleteFavorite_Factory create(Provider<AccountDao> accountDaoProvider,
      Provider<StoreDao> storeDaoProvider) {
    return new DeleteFavorite_Factory(accountDaoProvider, storeDaoProvider);
  }

  public static DeleteFavorite newInstance(AccountDao accountDao, StoreDao storeDao) {
    return new DeleteFavorite(accountDao, storeDao);
  }
}
