package com.itdoggz.projectrules.exception.util;

import com.itdoggz.projectrules.exception.FunctionE;

public final class Utils {

    private Utils() {}

    /**
     * @throws Exception if {@code FunctionE obj} is null
     */
    public static void requireNonNull(FunctionE obj) throws Exception {
        if (obj == null) {
            throw new Exception(new NullPointerException("FunctionE can't be null"));
        }
    }
}
