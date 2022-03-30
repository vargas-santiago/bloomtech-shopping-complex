package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Models.Request.CreateAccountRequest;
import com.bloomshoppingcomplex.Models.result.CreateAccountResult;
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

public class CreateAccountProvider implements RequestHandler<CreateAccountRequest, CreateAccountResult> {
    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    public CreateAccountProvider() {}

    @Override
    public CreateAccountResult handleRequest(final CreateAccountRequest createAccountRequest, Context context) {
        return dagger.provideCreateAccount().handleRequest(createAccountRequest, context);
    }
}
