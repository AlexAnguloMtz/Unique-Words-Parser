package com.alex.uniquewords;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * Unique words finder app
 *
 *    Goal ---> Find how many unique words (case-insensitive) are there in a text file.
 *
 *
 *    Requirements:
 *
 * -- Remove all 'fake words', such as numbers, spaces, special symbols, etc.
 *
 * -- Remove all the 'stop words', which are words that do not
 *    bring any significance on their own, such as 'the', 'is', 'and', etc.
 *    These 'stop words' will also be read from a text file.
 *
 * -- Print all the resulting unique words in lexicographical order
 *
 * -- Extra: Use Java 8 features
 *
 *    @author Alex Angulo
 *
 */

public class UniqueWordsApp {

    private final String sampleFileName;
    private final List<String> stopWords;

    public UniqueWordsApp(String sampleFileName, String stopWordsFileName) {
        this.stopWords = readLinesInLowerCase(stopWordsFileName);
        this.sampleFileName = sampleFileName;
    }

    public void run() {
        Stream.of(readLinesInLowerCase(sampleFileName))
                .map(this::parseWords)
                .map(this::removeStopWords)
                .map(this::removeDuplicates)
                .forEach(this::displayResults);
    }

    private List<String> readLinesInLowerCase(String fileName) {
        return new SimpleFileReader().readLinesInLowerCase(fileName);
    }

    private List<String> parseWords(Collection<String> strings) {
        return new WordParser().parseWords(strings);
    }

    private List<String> removeStopWords(List<String> strings) {
        strings.removeAll(stopWords);
        return strings;
    }

    private Set<String> removeDuplicates(Collection<String> words) {
        // Return a TreeSet, for 2 reasons:
        // 1. To remove duplicates
        // 2. To sort by lexicographical order
        return new TreeSet<>(words);
    }

    private void displayResults(Set<String> uniqueWords) {
        display(finalMessage(uniqueWords));
        uniqueWords.forEach(this::display);
        display(finalMessage(uniqueWords));
    }

    private String finalMessage(Set<String> uniqueWords) {
        final String finalMessage = "\n\n ============ Unique words in %s = %d ============ \n\n";
        return format(finalMessage, sampleFileName, uniqueWords.size());
    }

    private void display(String string) {
        System.out.println(string);
    }

}
