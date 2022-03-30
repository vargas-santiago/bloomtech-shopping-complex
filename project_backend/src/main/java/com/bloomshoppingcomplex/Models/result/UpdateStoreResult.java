package com.bloomshoppingcomplex.Models.result;

import com.bloomshoppingcomplex.Models.StoreModel;

public class UpdateStoreResult {
    private StoreModel store;

    public UpdateStoreResult(Builder builder) { this.store = builder.store; }

    public StoreModel getStore() { return store; }

<<<<<<< HEAD
    public void setStoreModel(StoreModel store) { this.store = store; }
=======
    public void setStore(StoreModel store) { this.store = store; }
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private StoreModel store;

<<<<<<< HEAD
        public Builder withStoreModel(StoreModel storeToUse) {
=======
        public Builder withStore(StoreModel storeToUse) {
>>>>>>> a9d66749d7ed2e2574cfc99cf48c4bdb806bed2f
            this.store = storeToUse;
            return this;
        }

        public UpdateStoreResult build() { return new UpdateStoreResult(this); }
    }
}
