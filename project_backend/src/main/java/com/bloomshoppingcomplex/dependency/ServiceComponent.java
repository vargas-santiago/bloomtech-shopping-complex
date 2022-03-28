package com.bloomshoppingcomplex.dependency;


import com.bloomshoppingcomplex.EndPoint.CreateAccount;
import com.bloomshoppingcomplex.EndPoint.GetAccount;
import com.bloomshoppingcomplex.EndPoint.GetStoreInfo;
import com.bloomshoppingcomplex.EndPoint.UpdateAccount;
import dagger.Component;

import javax.inject.Singleton;


@Component(modules = DaoModule.class)
@Singleton
public interface ServiceComponent {
    CreateAccount provideCreateAccount();
    GetAccount provideGetAccount();
    UpdateAccount provideUpdateAccount();
    GetStoreInfo provideGetStoreInfo();
}
