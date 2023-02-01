package com.itdoggz.projectrules.transactor;

import com.itdoggz.projectrules.function.SupplierE;

import java.util.Optional;

/**
 * The abstraction for executing a code in a transaction
 */
public interface Transactor {

    /**
     * Execute a code in a transaction and return the result
     *
     * @param supplier A function that takes no arguments and returns a value of type A.
     * @return Optional<A>
     */
    <A> Optional<A> exec(SupplierE<A> supplier);

    /**
     * Runs the given target in a transaction.
     *
     * @param target The Runnable to execute.
     */
    void runInTransaction(Runnable target);
}
