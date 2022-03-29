package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Models.Request.UpdateStoreRequest;
import com.bloomshoppingcomplex.Models.result.UpdateStoreResult;
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

import java.security.Provider;

public class UpdateStoreProvider implements RequestHandler<UpdateStoreRequest, UpdateStoreResult> {

    public UpdateStoreProvider() {

    }

    @Override
    public UpdateStoreResult handleRequest(final UpdateStoreRequest updateStoreRequest, Context context) {
        return getServiceComponent().provideUpdateStore().handleRequest(updateStoreRequest, context);
    }

    private ServiceComponent getServiceComponent() {
        return DaggerServiceComponent.create();
    }
}