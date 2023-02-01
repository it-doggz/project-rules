package com.itdoggz.projectrules.exception;

import com.itdoggz.projectrules.function.FunctionE;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

final class Success<T> implements Try<T> {

    private final T value;

    public Success(T value) {
        this.value = value;
    }

    @Override
    public <U> Try<U> map(FunctionE<? super T, ? extends U> mapper) {
        return Try.of(() -> mapper.apply(value));
    }

    @Override
    public <U> Try<U> flatMap(Function<? super T, ? extends Try<? extends U>> mapper) {
        return (Try<U>) mapper.apply(value);
    }

    @Override
    public Optional<T> get() {
        return Optional.ofNullable(value);
    }

    @Override
    public Try<T> onException(Consumer<Exception> handler) {
        return this;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public String toString() {
        return "Success[" + value + "]";
    }
}
