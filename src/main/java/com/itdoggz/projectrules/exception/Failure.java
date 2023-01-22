package com.itdoggz.projectrules.exception;

import com.itdoggz.projectrules.function.FunctionE;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

final class Failure<T> implements Try<T> {

    private final Exception exception;

    public Failure(Exception exception) {
        this.exception = exception;
    }


    @Override
    public <U> Try<U> map(FunctionE<? super T, ? extends U> mapper) {
        return (Try<U>) this;
    }

    @Override
    public <U> Try<U> flatMap(Function<? super T, ? extends Try<? extends U>> mapper) {
        return (Try<U>) this;
    }

    @Override
    public Optional<T> get() {
        return Optional.empty();
    }

    @Override
    public Try<T> onException(Consumer<Exception> handler) {
        handler.accept(exception);
        return this;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }
}
