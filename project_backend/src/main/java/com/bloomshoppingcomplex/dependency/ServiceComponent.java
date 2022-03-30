package com.bloomshoppingcomplex.dependency;

import com.bloomshoppingcomplex.EndPoint.GetStore;
import com.bloomshoppingcomplex.EndPoint.*;
import dagger.Component;

import javax.inject.Singleton;


@Component(modules = DaoModule.class)
@Singleton
public interface ServiceComponent {
    AddFavorite provideAddFavorite();
    CreateAccount provideCreateAccount();
    DeleteFavorite provideDeleteFavorite();
    GetAccount provideGetAccount();
    GetStore provideGetStore();
    UpdateAccount provideUpdateAccount();
    UpdateStore provideUpdateStore();
}
