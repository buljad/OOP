package ru.nsu.izhuravskii;

import java.util.Arrays;

import java.lang.Object;

public class StackTests {
    private static boolean deepEquals(Object one, Object two) {
        if (one instanceof byte[])
            return Arrays.equals((byte[])one, (byte[])two);
        if (one instanceof char[])
            return Arrays.equals((char[])one, (char[])two);
        if (one instanceof short[])
            return Arrays.equals((short[])one, (short[])two);
        if (one instanceof int[])
            return Arrays.equals((int[])one, (int[])two);
        if (one instanceof long[])
            return Arrays.equals((long[])one, (long[])two);
        if (one instanceof boolean[])
            return Arrays.equals((boolean[])one, (boolean[])two);
        if (one instanceof float[])
            return Arrays.equals((float[])one, (float[])two);
        if (one instanceof double[])
            return Arrays.equals((double[])one, (double[])two);
        if (one instanceof Object[])
            return Arrays.equals((Object[])one, (Object[])two);
        return one.equals(two);
    }

    /**
     * The first Test with stack including only numbers.
     */


}
