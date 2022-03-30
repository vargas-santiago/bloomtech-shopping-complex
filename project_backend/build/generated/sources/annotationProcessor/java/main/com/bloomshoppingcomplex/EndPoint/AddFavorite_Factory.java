package com.bloomshoppingcomplex.EndPoint;

import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddFavorite_Factory implements Factory<AddFavorite> {
  private final Provider<AccountDao> accountDaoProvider;

  private final Provider<StoreDao> storeDaoProvider;

  public AddFavorite_Factory(
      Provider<AccountDao> accountDaoProvider, Provider<StoreDao> storeDaoProvider) {
    this.accountDaoProvider = accountDaoProvider;
    this.storeDaoProvider = storeDaoProvider;
  }

  @Override
  public AddFavorite get() {
    return new AddFavorite(accountDaoProvider.get(), storeDaoProvider.get());
  }

  public static AddFavorite_Factory create(
      Provider<AccountDao> accountDaoProvider, Provider<StoreDao> storeDaoProvider) {
    return new AddFavorite_Factory(accountDaoProvider, storeDaoProvider);
  }
}
