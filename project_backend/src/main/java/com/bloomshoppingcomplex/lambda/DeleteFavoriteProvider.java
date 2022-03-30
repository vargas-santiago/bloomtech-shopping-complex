package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Models.Request.DeleteFavoriteRequest;
import com.bloomshoppingcomplex.Models.result.DeleteFavoriteResult;
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

public class DeleteFavoriteProvider implements RequestHandler<DeleteFavoriteRequest, DeleteFavoriteResult> {
    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    public DeleteFavoriteProvider() {}

    @Override
    public DeleteFavoriteResult handleRequest(final DeleteFavoriteRequest deleteFavoriteRequest, Context context) {
        return dagger.provideDeleteFavorite().handleRequest(deleteFavoriteRequest, context);
    }
}
