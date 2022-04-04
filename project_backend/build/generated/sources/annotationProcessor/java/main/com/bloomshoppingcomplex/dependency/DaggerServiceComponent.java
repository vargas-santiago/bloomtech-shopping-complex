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
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerServiceComponent implements ServiceComponent {
  private final DaggerServiceComponent serviceComponent = this;

  private Provider<DynamoDBMapper> provideDynamoDBMapperProvider;

  private DaggerServiceComponent(DaoModule daoModuleParam) {

    initialize(daoModuleParam);

  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServiceComponent create() {
    return new Builder().build();
  }

  private AccountDao accountDao() {
    return new AccountDao(provideDynamoDBMapperProvider.get());
  }

  private StoreDao storeDao() {
    return new StoreDao(provideDynamoDBMapperProvider.get());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final DaoModule daoModuleParam) {
    this.provideDynamoDBMapperProvider = DoubleCheck.provider(DaoModule_ProvideDynamoDBMapperFactory.create(daoModuleParam));
  }

  @Override
  public AddFavorite provideAddFavorite() {
    return new AddFavorite(accountDao(), storeDao());
  }

  @Override
  public CreateAccount provideCreateAccount() {
    return new CreateAccount(accountDao());
  }

  @Override
  public DeleteFavorite provideDeleteFavorite() {
    return new DeleteFavorite(accountDao(), storeDao());
  }

  @Override
  public GetAccount provideGetAccount() {
    return new GetAccount(accountDao());
  }

  @Override
  public GetStore provideGetStore() {
    return new GetStore(storeDao());
  }

  @Override
  public UpdateAccount provideUpdateAccount() {
    return new UpdateAccount(accountDao());
  }

  @Override
  public UpdateStore provideUpdateStore() {
    return new UpdateStore(storeDao());
  }

  public static final class Builder {
    private DaoModule daoModule;

    private Builder() {
    }

    public Builder daoModule(DaoModule daoModule) {
      this.daoModule = Preconditions.checkNotNull(daoModule);
      return this;
    }

    public ServiceComponent build() {
      if (daoModule == null) {
        this.daoModule = new DaoModule();
      }
      return new DaggerServiceComponent(daoModule);
    }
  }
}
