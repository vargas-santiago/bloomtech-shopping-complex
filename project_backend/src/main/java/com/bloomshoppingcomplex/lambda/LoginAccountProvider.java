package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Models.Request.LoginAccountRequest;
import com.bloomshoppingcomplex.Models.result.LoginAccountResult;
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

public class LoginAccountProvider implements RequestHandler<LoginAccountRequest, LoginAccountResult> {
    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    public LoginAccountProvider() {}

    @Override
    public LoginAccountResult handleRequest(final LoginAccountRequest loginAccountRequest, Context context) {
        return dagger.provideLoginAccount().handleRequest(loginAccountRequest, context);
    }
}
