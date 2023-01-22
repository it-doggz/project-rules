package com.itdoggz.projectrules.exception;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public sealed interface Try<T> permits Success, Failure {

    /**
     * Calls f ({@link SupplierE}); if f throws an {@code Exception}, returns {@code Exception}
     * wrapped by {@link Failure}, else returns the result of {@code f.call()} wrapped by {@link Success}
     *
     * @param f {@code CallableE<T>}
     * @return {@code Try<T>}
     */
    static <T> Try<T> of(SupplierE<T> f) {
        try {
            return new Success<>(f.get());
        } catch (Exception e) {
            return new Failure<>(e);
        }
    }

    /**
     * Returns the result of applying the given mapping function to
     * the value
     *
     * @param mapper the mapping function to apply to a value
     * @param <U>    The type of the value returned from the mapping function
     * @return a {@code Try} describing the result of applying a mapping
     * function to the value of this {@code Try}
     */
    <U> Try<U> map(FunctionE<? super T, ? extends U> mapper);

    /**
     * Returns the result of applying the given
     * {@code Try}-bearing mapping function to the value.
     *
     * <p>This method is similar to {@link #map(FunctionE)}, but the mapping
     * function is one whose result is already an {@code Try}, and if
     * invoked, {@code flatMap} does not wrap it within an additional
     * {@code Try}.
     *
     * @param <U>    The type of value of the {@code Try} returned by the
     *               mapping function
     * @param mapper the mapping function to apply to a value
     * @return the result of applying an {@code Try}-bearing mapping
     * function to the value of this {@code Try}
     */
    <U> Try<U> flatMap(Function<? super T, ? extends Try<? extends U>> mapper);

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
    Try<T> onException(Consumer<Exception> handler);


    /**
     * Checking if the Try is a Success or Failure.
     *
     * @return boolean
     */
    boolean isSuccess();
}
