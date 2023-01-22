package com.itdoggz.projectrules.function;

import static com.itdoggz.projectrules.util.Utils.requireNonNull;

/**
 * A functional interface that takes a value of type T and returns a value of type R, and it may throw an exception.
 * A realization of {@link java.util.function.Function} with exception
 */
@FunctionalInterface
public interface FunctionE<T, R> {

    /**
     * It takes a value of type T and returns a value of type R, and it may throw an exception.
     *
     * @param t the input value
     * @return the function result
     */
    R apply(T t) throws Exception;

    /**
     * Returns a composed function that first applies the before function to its input, and then applies this function to
     * the result.
     *
     * @param before the function to apply before this function is applied
     * @return A FunctionE that takes a V and returns an R.
     * @throws Exception if before is null
     */
    default <V> FunctionE<V, R> compose(FunctionE<? super V, ? extends T> before) throws Exception {
        requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    /**
     * Returns a composed function that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <V>   the type of output of the {@code after} function, and of the
     *              composed function
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then
     * applies the {@code after} function
     * @throws Exception if after is null
     */
    default <V> FunctionE<T, V> andThen(FunctionE<? super R, ? extends V> after) throws Exception {
        requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    /**
     * Returns a function that always returns its input argument.
     *
     * @param <T> the type of the input and output objects to the function
     * @return a function that always returns its input argument
     */
    static <T> FunctionE<T, T> identity() {
        return t -> t;
    }
}
