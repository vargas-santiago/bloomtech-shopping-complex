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
public final class GetStore_Factory implements Factory<GetStore> {
  private final Provider<StoreDao> storeDaoProvider;

  public GetStore_Factory(Provider<StoreDao> storeDaoProvider) {
    this.storeDaoProvider = storeDaoProvider;
  }

  @Override
  public GetStore get() {
    return newInstance(storeDaoProvider.get());
  }

  public static GetStore_Factory create(Provider<StoreDao> storeDaoProvider) {
    return new GetStore_Factory(storeDaoProvider);
  }

  public static GetStore newInstance(StoreDao storeDao) {
    return new GetStore(storeDao);
  }
}
