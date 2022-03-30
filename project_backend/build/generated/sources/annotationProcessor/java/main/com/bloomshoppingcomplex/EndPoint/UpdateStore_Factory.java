package com.bloomshoppingcomplex.EndPoint;

import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UpdateStore_Factory implements Factory<UpdateStore> {
  private final Provider<StoreDao> storeDaoProvider;

  public UpdateStore_Factory(Provider<StoreDao> storeDaoProvider) {
    this.storeDaoProvider = storeDaoProvider;
  }

  @Override
  public UpdateStore get() {
    return new UpdateStore(storeDaoProvider.get());
  }

  public static UpdateStore_Factory create(Provider<StoreDao> storeDaoProvider) {
    return new UpdateStore_Factory(storeDaoProvider);
  }
}
