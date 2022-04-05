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
public final class AccountDao_Factory implements Factory<AccountDao> {
  private final Provider<DynamoDBMapper> dynamoDbMapperProvider;

  public AccountDao_Factory(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    this.dynamoDbMapperProvider = dynamoDbMapperProvider;
  }

  @Override
  public AccountDao get() {
    return newInstance(dynamoDbMapperProvider.get());
  }

  public static AccountDao_Factory create(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    return new AccountDao_Factory(dynamoDbMapperProvider);
  }

  public static AccountDao newInstance(DynamoDBMapper dynamoDbMapper) {
    return new AccountDao(dynamoDbMapper);
  }
}
