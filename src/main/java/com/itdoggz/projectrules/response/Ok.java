package com.itdoggz.projectrules.response;

import java.util.Optional;
import java.util.function.Consumer;

record Ok<T>(Payload<T> payload) implements Response<T> {

    @Override
    public Optional<T> get() {
        return Optional.ofNullable(payload().result());
    }

    @Override
    public Response<T> onException(Consumer<Exception> handler) {
        return this;
    }

}
