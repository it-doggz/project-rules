package com.itdoggz.projectrules.util;

import com.itdoggz.projectrules.function.FunctionE;

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
