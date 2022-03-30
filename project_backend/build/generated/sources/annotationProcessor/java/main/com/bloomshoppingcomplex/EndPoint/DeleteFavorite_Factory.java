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
public final class DeleteFavorite_Factory implements Factory<DeleteFavorite> {
  private final Provider<AccountDao> accountDaoProvider;

  private final Provider<StoreDao> storeDaoProvider;

  public DeleteFavorite_Factory(
      Provider<AccountDao> accountDaoProvider, Provider<StoreDao> storeDaoProvider) {
    this.accountDaoProvider = accountDaoProvider;
    this.storeDaoProvider = storeDaoProvider;
  }

  @Override
  public DeleteFavorite get() {
    return new DeleteFavorite(accountDaoProvider.get(), storeDaoProvider.get());
  }

  public static DeleteFavorite_Factory create(
      Provider<AccountDao> accountDaoProvider, Provider<StoreDao> storeDaoProvider) {
    return new DeleteFavorite_Factory(accountDaoProvider, storeDaoProvider);
  }
}
