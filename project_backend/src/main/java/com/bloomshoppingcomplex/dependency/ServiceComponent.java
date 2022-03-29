package com.bloomshoppingcomplex.dependency;


import com.bloomshoppingcomplex.EndPoint.*;
import dagger.Component;

import javax.inject.Singleton;


@Component(modules = DaoModule.class)
@Singleton
public interface ServiceComponent {
    CreateAccount provideCreateAccount();
    GetAccount provideGetAccount();
    UpdateAccount provideUpdateAccount();
    GetStoreInfo provideGetStoreInfo();
    UpdateStore provideUpdateStore();
}
