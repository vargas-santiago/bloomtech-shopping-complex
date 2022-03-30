package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Models.Request.AddFavoriteRequest;
import com.bloomshoppingcomplex.Models.result.AddFavoriteResult;
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

public class AddFavoriteProvider implements RequestHandler<AddFavoriteRequest, AddFavoriteResult> {
    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    public AddFavoriteProvider() {}

    @Override
    public AddFavoriteResult handleRequest(final AddFavoriteRequest addFavoriteRequest, Context context) {
        return dagger.provideAddFavorite().handleRequest(addFavoriteRequest, context);
    }
}
