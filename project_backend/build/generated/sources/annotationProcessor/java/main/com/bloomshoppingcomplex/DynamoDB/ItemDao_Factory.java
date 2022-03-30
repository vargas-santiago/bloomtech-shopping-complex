package com.bloomshoppingcomplex.DynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ItemDao_Factory implements Factory<ItemDao> {
  private final Provider<DynamoDBMapper> dynamoDbMapperProvider;

  public ItemDao_Factory(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    this.dynamoDbMapperProvider = dynamoDbMapperProvider;
  }

  @Override
  public ItemDao get() {
    return new ItemDao(dynamoDbMapperProvider.get());
  }

  public static ItemDao_Factory create(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    return new ItemDao_Factory(dynamoDbMapperProvider);
  }
}
