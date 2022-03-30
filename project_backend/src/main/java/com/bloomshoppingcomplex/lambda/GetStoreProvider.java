package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Models.Request.GetStoreRequest;
import com.bloomshoppingcomplex.Models.result.GetStoreResult;
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

<<<<<<< HEAD:project_backend/src/main/java/com/bloomshoppingcomplex/lambda/GetStoreProvider.java
public class GetStoreProvider implements RequestHandler<GetStoreRequest, GetStoreResult> {
    public GetStoreProvider() {
=======
public class GetStoreInfoProvider implements RequestHandler<GetStoreInfoRequest, GetStoreInfoResult> {
    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    public GetStoreInfoProvider() {
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f:project_backend/src/main/java/com/bloomshoppingcomplex/lambda/GetStoreInfoProvider.java

    }

    @Override
<<<<<<< HEAD:project_backend/src/main/java/com/bloomshoppingcomplex/lambda/GetStoreProvider.java
    public GetStoreResult handleRequest(final GetStoreRequest getStoreRequest, Context context) {
        return getServiceComponent().provideGetStoreInfo().handleRequest(getStoreRequest, context);
=======
    public GetStoreInfoResult handleRequest(final GetStoreInfoRequest getStoreInfoRequest, Context context) {
        return dagger.provideGetStoreInfo().handleRequest(getStoreInfoRequest, context);
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f:project_backend/src/main/java/com/bloomshoppingcomplex/lambda/GetStoreInfoProvider.java
    }
}
