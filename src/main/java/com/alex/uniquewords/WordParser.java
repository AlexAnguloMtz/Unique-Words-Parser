package com.alex.uniquewords;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

public class WordParser {

    private static final String WORD_DELIMITERS =
            "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*|\\d+|=|'+|\\*+|\\ª+"
            + "|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*";

    public List<String> parseWords(Collection<String> lines) {
       final List<String> parsedWords = new ArrayList<>();
        for (String line : lines) {
            parsedWords.addAll(wordsIn(line));
        }
        return parsedWords;
    }

    private Collection<String> wordsIn(String line) {
        return asList(line.split(WORD_DELIMITERS));
    }


}