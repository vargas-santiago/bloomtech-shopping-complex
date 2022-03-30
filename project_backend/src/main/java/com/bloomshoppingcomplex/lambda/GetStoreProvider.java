package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Models.Request.GetStoreRequest;
import com.bloomshoppingcomplex.Models.result.GetStoreResult;
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

public class GetStoreProvider implements RequestHandler<GetStoreRequest, GetStoreResult> {
    public GetStoreProvider() {

    }

    @Override
    public GetStoreResult handleRequest(final GetStoreRequest getStoreRequest, Context context) {
        return getServiceComponent().provideGetStoreInfo().handleRequest(getStoreRequest, context);
    }

    private ServiceComponent getServiceComponent() { return DaggerServiceComponent.create(); }
}
