package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Models.Request.GetStoreRequest;
import com.bloomshoppingcomplex.Models.result.GetStoreResult;
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

public class GetStoreProvider implements RequestHandler<GetStoreRequest, GetStoreResult> {
    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    public GetStoreProvider() {}

    @Override
    public GetStoreResult handleRequest(final GetStoreRequest getStoreRequest, Context context) {
        return dagger.provideGetStore().handleRequest(getStoreRequest, context);
    }
}
