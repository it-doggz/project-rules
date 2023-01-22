package com.itdoggz.projectrules.exception;

/**
 * The analog of {@link java.util.function.Supplier}, but can throw exception
 *
 * @param <T> the type of results supplied by this supplier
 */
@FunctionalInterface
public interface SupplierE<T> {

    /**
     * Get() returns a result, and may throw an Exception.
     *
     * @return a result
     */
    T get() throws Exception;
}
