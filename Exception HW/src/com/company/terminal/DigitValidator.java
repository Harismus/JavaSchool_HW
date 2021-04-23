package com.company.terminal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitValidator {
    static private Pattern p = Pattern.compile( "(([0-9]){0,}([\\.]){0,})+" );

    static boolean isMatch(String text) {
        Matcher m = p.matcher( text );
        return m.matches();
    }
}
