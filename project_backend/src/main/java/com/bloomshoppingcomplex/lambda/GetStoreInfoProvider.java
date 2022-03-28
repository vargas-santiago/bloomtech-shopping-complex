package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Models.Request.GetStoreInfoRequest;
import com.bloomshoppingcomplex.Models.result.GetStoreInfoResult;
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

public class GetStoreInfoProvider implements RequestHandler<GetStoreInfoRequest, GetStoreInfoResult> {
    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    public GetStoreInfoProvider() {

    }

    @Override
    public GetStoreInfoResult handleRequest(final GetStoreInfoRequest getStoreInfoRequest, Context context) {
        return dagger.provideGetStoreInfo().handleRequest(getStoreInfoRequest, context);
    }
}
