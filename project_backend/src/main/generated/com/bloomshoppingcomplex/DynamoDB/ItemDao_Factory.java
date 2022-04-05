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
public final class ItemDao_Factory implements Factory<ItemDao> {
  private final Provider<DynamoDBMapper> dynamoDbMapperProvider;

  public ItemDao_Factory(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    this.dynamoDbMapperProvider = dynamoDbMapperProvider;
  }

  @Override
  public ItemDao get() {
    return newInstance(dynamoDbMapperProvider.get());
  }

  public static ItemDao_Factory create(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    return new ItemDao_Factory(dynamoDbMapperProvider);
  }

  public static ItemDao newInstance(DynamoDBMapper dynamoDbMapper) {
    return new ItemDao(dynamoDbMapper);
  }
}
