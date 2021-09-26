package SortingWordsTask;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException  {

        WordsArray wordsArray = new WordsArray(){};
        wordsArray.fileToArray("src/main/java/SortingWordsTask/Words.txt");

        System.out.println("Выведение статистики по всем словам на экран");
        wordsArray.print();
        System.out.println("=================");

        System.out.println("Сортировка по алфавиту от А до Я");
        wordsArray.sortingWordAZ();
        wordsArray.printArray();
        System.out.println("=================");

        System.out.println("Сортировка по алфавиту от Я до А");
        wordsArray.sortingWordZA();
        wordsArray.printArray();
        System.out.println("=================");

        System.out.println("Сортировка по возрастанию количества слов");
        wordsArray.sortingAmountAscending();
        wordsArray.printArray();
        System.out.println("=================");

        System.out.println("Сортировка по убыванию количества слова");
        wordsArray.sortingAmountDescending();
        wordsArray.printArray();
        System.out.println("=================");

        System.out.println("Выведение самого(ых) часто употребляемых слов");
        wordsArray.mostCommonWords();
        System.out.println("=================");

    }
}
