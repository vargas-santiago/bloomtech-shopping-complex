package com.bloomshoppingcomplex.DynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
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
public final class StoreDao_Factory implements Factory<StoreDao> {
  private final Provider<DynamoDBMapper> dynamoDbMapperProvider;

  public StoreDao_Factory(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    this.dynamoDbMapperProvider = dynamoDbMapperProvider;
  }

  @Override
  public StoreDao get() {
    return newInstance(dynamoDbMapperProvider.get());
  }

  public static StoreDao_Factory create(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    return new StoreDao_Factory(dynamoDbMapperProvider);
  }

  public static StoreDao newInstance(DynamoDBMapper dynamoDbMapper) {
    return new StoreDao(dynamoDbMapper);
  }
}
