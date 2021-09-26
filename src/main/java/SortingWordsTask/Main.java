package SortingWordsTask;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException  {

        WordsArray wordsArray = new WordsArray(){};
        wordsArray.fileToArray("src/main/java/SortingWordsTask/Words.txt");
        wordsArray.print();

    }
}
