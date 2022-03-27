package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Request.GetStoreInfoRequest;
import com.bloomshoppingcomplex.Request.result.GetStoreInfoResult;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

public class GetStoreInfoProvider implements RequestHandler<GetStoreInfoRequest, GetStoreInfoResult> {
    public GetStoreInfoProvider() {

    }

    @Override
    public GetStoreInfoResult handleRequest(final GetStoreInfoRequest getStoreInfoRequest, Context context) {
        return getServiceComponent().provideGetStoreInfo().handleRequest(getStoreInfoRequest, context);
    }

    private ServiceComponent getServiceComponent() { return DaggerServiceComponent.create(); }
}
