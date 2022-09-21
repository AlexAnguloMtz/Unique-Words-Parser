package com.alex.uniquewords;

public class UniqueWordsMain {

    private static final String SAMPLE_TEXT_FILE_NAME = "divina_comedia.txt";
    private static final String STOP_WORDS_FILE_NAME = "stopwords-es.txt";

    public static void main(String[] args) {
        final var app = new UniqueWordsApp(SAMPLE_TEXT_FILE_NAME, STOP_WORDS_FILE_NAME);
        app.run();
    }

}
