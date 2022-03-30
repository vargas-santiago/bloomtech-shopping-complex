package com.bloomshoppingcomplex.Models.result;

import com.bloomshoppingcomplex.Models.StoreModel;

public class GetStoreResult {
    private StoreModel storeModel;

    public GetStoreResult(Builder builder) { this.storeModel = builder.storeModel; }

    public StoreModel getStoreModel() { return storeModel; }

    public void setStoreModel(StoreModel storeModel) { this.storeModel = storeModel; }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private StoreModel storeModel;

        public Builder withStoreModel(StoreModel storeModel) {
            this.storeModel = storeModel;
            return this;
        }

        public GetStoreResult build() { return new GetStoreResult(this); }
    }
}
