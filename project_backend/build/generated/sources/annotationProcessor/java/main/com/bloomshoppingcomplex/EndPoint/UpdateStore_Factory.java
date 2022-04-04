package com.bloomshoppingcomplex.EndPoint;

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
public final class UpdateStore_Factory implements Factory<UpdateStore> {
  private final Provider<StoreDao> storeDaoProvider;

  public UpdateStore_Factory(Provider<StoreDao> storeDaoProvider) {
    this.storeDaoProvider = storeDaoProvider;
  }

  @Override
  public UpdateStore get() {
    return newInstance(storeDaoProvider.get());
  }

  public static UpdateStore_Factory create(Provider<StoreDao> storeDaoProvider) {
    return new UpdateStore_Factory(storeDaoProvider);
  }

  public static UpdateStore newInstance(StoreDao storeDao) {
    return new UpdateStore(storeDao);
  }
}
