package com.itdoggz.projectrules.transactor;

import com.itdoggz.projectrules.function.FunctionE;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * The abstraction for executing a code in a transaction and working with EntityManager
 *
 * @param <EM> EntityManager
 */
public interface EntityManagerTransactor<EM> extends Transactor {

    /**
     * The method for working with EntityManager
     *
     * @param action The action to be performed
     */
    void apply(Consumer<EM> action);

    /**
     * Map takes a function that takes an EM and returns an Optional<A>
     *
     * @param mapper A {@link FunctionE}, that takes EntityManager and return A.
     * @return Optional<A>
     */
    <A> Optional<A> map(FunctionE<EM, A> mapper);
}
