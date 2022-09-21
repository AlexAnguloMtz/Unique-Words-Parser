package com.alex.uniquewords;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SimpleFileReader {

    public List<String> readLinesInLowerCase(String fileName) {
        return allLowerCase(readLines(fileName));
    }

    public List<String> readLines(String fileName) {
        try {
            return Files.readAllLines(path(fileName));
        } catch (URISyntaxException | IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private List<String> allLowerCase(List<String> lines) {
        return lines.stream()
                .map(String::toLowerCase)
                .collect(toList());
    }

    private Path path(String fileName) throws URISyntaxException {
        return Paths.get(new File(fileName).toURI());
    }
}
