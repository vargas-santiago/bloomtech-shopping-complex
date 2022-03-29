package com.bloomshoppingcomplex.Models.result;

import com.bloomshoppingcomplex.Models.StoreModel;

public class UpdateStoreResult {
    private StoreModel store;

    public UpdateStoreResult(Builder builder) { this.store = builder.store; }

    public StoreModel getStore() { return store; }

    public void setStore(StoreModel store) { this.store = store; }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private StoreModel store;

        public Builder withStore(StoreModel storeToUse) {
            this.store = storeToUse;
            return this;
        }

        public UpdateStoreResult build() { return new UpdateStoreResult(this); }
    }
}
