package com.bloomshoppingcomplex.dependency;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.StoreDao;
import com.bloomshoppingcomplex.EndPoint.AddFavorite;
import com.bloomshoppingcomplex.EndPoint.CreateAccount;
import com.bloomshoppingcomplex.EndPoint.DeleteFavorite;
import com.bloomshoppingcomplex.EndPoint.GetAccount;
import com.bloomshoppingcomplex.EndPoint.GetStore;
import com.bloomshoppingcomplex.EndPoint.UpdateAccount;
import com.bloomshoppingcomplex.EndPoint.UpdateStore;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerServiceComponent implements ServiceComponent {
  private Provider<DynamoDBMapper> provideDynamoDBMapperProvider;

  private DaggerServiceComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServiceComponent create() {
    return new Builder().build();
  }

  private AccountDao getAccountDao() {
    return new AccountDao(provideDynamoDBMapperProvider.get());
  }

  private StoreDao getStoreDao() {
    return new StoreDao(provideDynamoDBMapperProvider.get());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideDynamoDBMapperProvider =
        DoubleCheck.provider(DaoModule_ProvideDynamoDBMapperFactory.create(builder.daoModule));
  }

  @Override
  public AddFavorite provideAddFavorite() {
    return new AddFavorite(getAccountDao(), getStoreDao());
  }

  @Override
  public CreateAccount provideCreateAccount() {
    return new CreateAccount(getAccountDao());
  }

  @Override
  public DeleteFavorite provideDeleteFavorite() {
    return new DeleteFavorite(getAccountDao(), getStoreDao());
  }

  @Override
  public GetAccount provideGetAccount() {
    return new GetAccount(getAccountDao());
  }

  @Override
  public GetStore provideGetStore() {
    return new GetStore(getStoreDao());
  }

  @Override
  public UpdateAccount provideUpdateAccount() {
    return new UpdateAccount(getAccountDao());
  }

  @Override
  public UpdateStore provideUpdateStore() {
    return new UpdateStore(getStoreDao());
  }

  public static final class Builder {
    private DaoModule daoModule;

    private Builder() {}

    public ServiceComponent build() {
      if (daoModule == null) {
        this.daoModule = new DaoModule();
      }
      return new DaggerServiceComponent(this);
    }

    public Builder daoModule(DaoModule daoModule) {
      this.daoModule = Preconditions.checkNotNull(daoModule);
      return this;
    }
  }
}
