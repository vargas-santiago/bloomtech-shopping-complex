package com.bloomshoppingcomplex.EndPoint;

import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetStore_Factory implements Factory<GetStore> {
  private final Provider<StoreDao> storeDaoProvider;

  public GetStore_Factory(Provider<StoreDao> storeDaoProvider) {
    this.storeDaoProvider = storeDaoProvider;
  }

  @Override
  public GetStore get() {
    return new GetStore(storeDaoProvider.get());
  }

  public static GetStore_Factory create(Provider<StoreDao> storeDaoProvider) {
    return new GetStore_Factory(storeDaoProvider);
  }
}
