package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Models.Request.UpdateStoreRequest;
import com.bloomshoppingcomplex.Models.result.UpdateStoreResult;
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

public class UpdateStoreProvider implements RequestHandler<UpdateStoreRequest, UpdateStoreResult> {
    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    public UpdateStoreProvider() {}

    @Override
    public UpdateStoreResult handleRequest(final UpdateStoreRequest updateStoreRequest, Context context) {
        return dagger.provideUpdateStore().handleRequest(updateStoreRequest, context);
    }

}