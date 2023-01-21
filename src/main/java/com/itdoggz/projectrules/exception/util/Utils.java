package com.itdoggz.projectrules.exception.util;

public final class Utils {

    private Utils() {}

    /**
     * @throws Exception if {@code obj} is null
     */
    public static <X> void requireNonNull(X obj) throws Exception {
        if (obj == null) {
            throw new Exception(new NullPointerException("FunctionE can't be null"));
        }
    }
}
