package com.bloomshoppingcomplex.DynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AccountDao_Factory implements Factory<AccountDao> {
  private final Provider<DynamoDBMapper> dynamoDbMapperProvider;

  public AccountDao_Factory(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    this.dynamoDbMapperProvider = dynamoDbMapperProvider;
  }

  @Override
  public AccountDao get() {
    return new AccountDao(dynamoDbMapperProvider.get());
  }

  public static AccountDao_Factory create(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    return new AccountDao_Factory(dynamoDbMapperProvider);
  }
}
