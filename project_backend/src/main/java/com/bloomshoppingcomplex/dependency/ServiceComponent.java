package com.bloomshoppingcomplex.dependency;


<<<<<<< HEAD
import com.bloomshoppingcomplex.EndPoint.GetStore;
=======
import com.bloomshoppingcomplex.EndPoint.*;
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f
import dagger.Component;

import javax.inject.Singleton;


@Component(modules = DaoModule.class)
@Singleton
public interface ServiceComponent {
<<<<<<< HEAD
    GetStore provideGetStoreInfo();
=======
    CreateAccount provideCreateAccount();
    GetAccount provideGetAccount();
    UpdateAccount provideUpdateAccount();
    GetStoreInfo provideGetStoreInfo();
    UpdateStore provideUpdateStore();
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f
}
