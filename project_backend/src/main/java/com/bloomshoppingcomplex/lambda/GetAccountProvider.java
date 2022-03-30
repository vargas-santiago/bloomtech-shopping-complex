package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Models.Request.GetAccountRequest;
import com.bloomshoppingcomplex.Models.result.GetAccountResult;
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

public class GetAccountProvider implements RequestHandler<GetAccountRequest, GetAccountResult>{
        private static final ServiceComponent dagger = DaggerServiceComponent.create();

        public GetAccountProvider() {}

    @Override
    public GetAccountResult handleRequest(GetAccountRequest getAccountRequest, Context context) {
        return dagger.provideGetAccount().handleRequest(getAccountRequest, context);
    }
}
