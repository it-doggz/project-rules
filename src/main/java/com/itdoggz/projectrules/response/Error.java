package com.itdoggz.projectrules.response;

import java.util.Optional;
import java.util.function.Consumer;

record Error<T>(PayloadWithException payload) implements Response<T> {

    @Override
    public Optional<T> get() {
        return Optional.empty();
    }

    @Override
    public Response<T> onException(Consumer<Exception> handler) {
        handler.accept(payload.exception());
        return this;
    }

}
