package com.bloomshoppingcomplex.Util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;


import java.util.regex.Pattern;

public class AccountUtils {
    private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("[\"\'\\\\]");

    // Generates a fixed user ID length
    static final int ACCOUNT_ID_LENGTH = 5;

    private AccountUtils() {}

    public static boolean isValidString(final String stringToValidate) {
        if (StringUtils.isBlank(stringToValidate)) {
            return false;
        }

        return !INVALID_CHARACTER_PATTERN.matcher(stringToValidate).find();
    }

    // Generate Id method
    public static String generateUserId() {
        return RandomStringUtils.randomAlphanumeric(ACCOUNT_ID_LENGTH);
    }
}
