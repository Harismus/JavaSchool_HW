package com.company;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TextParser {
    static public Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordsInfo = new HashMap<>();
        List<String> stringList = ArrayCast.from(text);

        for (String string : stringList) {
            Integer val = wordsInfo.get(string);
            if (val == null)
                wordsInfo.put(string, 1);
            else
                wordsInfo.put(string, ++val);
        }

        return wordsInfo;
    }


}
