package com.itdoggz.projectrules.response;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public sealed interface Response<T> permits Ok, Error {

    static <T> Response<T> of(Supplier<T> f) {
        try {
            return new Ok<>(new Payload<>(f.get()));
        } catch (Exception e) {
            return new Error<>(new PayloadWithException(e));
        }
    }

    /**
     * Returns the value of this Try
     *
     * @return value wrapped by {@link Optional}
     */
    Optional<T> get();

    /**
     * A method that allows you to handle the exception.
     *
     * @return this {@code Try}
     */
    Response<T> onException(Consumer<Exception> handler);

}
