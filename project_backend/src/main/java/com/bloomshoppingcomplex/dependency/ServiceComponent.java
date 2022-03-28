package com.bloomshoppingcomplex.dependency;


import com.bloomshoppingcomplex.EndPoint.GetStoreInfo;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    GetStoreInfo provideGetStoreInfo();
}
