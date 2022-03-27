package com.bloomshoppingcomplex.Request.result;

import com.bloomshoppingcomplex.Models.StoreModel;
import org.junit.jupiter.api.extension.ExtensionContext;

public class GetStoreInfoResult {
    private StoreModel store;

    public GetStoreInfoResult(Builder builder) { this.store = builder.store; }

    public StoreModel getStore() { return store; }

    public void setStore(StoreModel store) { this.store = store; }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private StoreModel store;

        public Builder withStore(StoreModel storeToUse) {
            this.store = storeToUse;
            return this;
        }

        public GetStoreInfoResult build() { return new GetStoreInfoResult(this); }
    }
}
