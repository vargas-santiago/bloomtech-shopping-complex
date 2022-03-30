package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
<<<<<<< HEAD
import com.bloomshoppingcomplex.Models.Request.UpdateAccountRequest;
import com.bloomshoppingcomplex.Request.result.UpdateAccountResult;
=======
import com.bloomshoppingcomplex.Models.result.UpdateAccountResult;
import com.bloomshoppingcomplex.Models.Request.UpdateAccountRequest;
>>>>>>> 15cc05d61fcf14dd27fe90316db5287363210205
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

public class UpdateAccountProvider implements RequestHandler<UpdateAccountRequest, UpdateAccountResult> {
    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    public UpdateAccountProvider() {}

    @Override
    public UpdateAccountResult handleRequest(UpdateAccountRequest updateAccountRequest, Context context) {
        return dagger.provideUpdateAccount().handleRequest(updateAccountRequest, context);
    }
}
