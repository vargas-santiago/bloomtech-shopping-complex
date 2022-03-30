package com.bloomshoppingcomplex.DynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StoreDao_Factory implements Factory<StoreDao> {
  private final Provider<DynamoDBMapper> dynamoDbMapperProvider;

  public StoreDao_Factory(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    this.dynamoDbMapperProvider = dynamoDbMapperProvider;
  }

  @Override
  public StoreDao get() {
    return new StoreDao(dynamoDbMapperProvider.get());
  }

  public static StoreDao_Factory create(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    return new StoreDao_Factory(dynamoDbMapperProvider);
  }
}
