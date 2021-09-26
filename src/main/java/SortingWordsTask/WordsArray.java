package SortingWordsTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class WordsArray {

    private ArrayList<Word> wordsArray = new ArrayList<>();
    private String[] stringArray;
    private String[] wordArray;

    private void addWordToArray(String word){
        wordsArray.add(new Word(word, 1));
    }

    /**
     * проверка наличия слова в массиве
     */
    private boolean wordInsideTheArrayOfObjects(String word) {
        boolean flag = false;
        for (Word value : wordsArray) {
            if (value.getWord().equalsIgnoreCase(word)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * поиск индекса с одинаковым индексом.
     */
    private int indexOfEqualElement(String word) {
        int index = 0;
        for (int i = 0; i < wordsArray.size(); i++) {
            if (wordsArray.get(i).getWord().equalsIgnoreCase(word)) {
                index = i;
            }
        }
        return index;
    }

    public void fileToArray(String path) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stringArray = stream.toArray(String[]::new);
        }
        for (String s : stringArray) {
            wordArray = s.toLowerCase(Locale.ROOT).split("[.,!?\\s]+");
            for (String value : wordArray) {
                if (wordInsideTheArrayOfObjects(value)) {
                    wordsArray.get(indexOfEqualElement(value)).plusAmount();
                } else {
                    addWordToArray(value);
                }
            }
        }
    }

    /**
     * Выведение статистики по всем словам на экран (сколько раз встречалось, что за
     * слово, частота употребления (%)
     **/

    public void print(){
        int wordCounter = 0;
        for (int i = 0; i < wordsArray.size(); i++){
            wordCounter = wordCounter + wordsArray.get(i).getAmount();
        }
        for (int i = 0; i < wordsArray.size(); i++) {
            System.out.println(i+1 + ". " +
                    "количество: " + wordsArray.get(i).getAmount() +
                    " | слово: " + wordsArray.get(i).getWord() +
                    " . Частота употребления: " + ((wordsArray.get(i).getAmount()*100)/wordCounter) + "%");
        }
    }

    /**
     * Сортировка по алфавиту от А до Я
     */
    public void sortingWordAZ() {
        wordsArray.sort(comparing(Word::getWord));
    }

    /**
     * Сортировка по алфавиту от Я до А
     */
    public void sortingWordZA() {
        wordsArray.sort(comparing(Word::getWord).reversed());
    }

    /**
     * Сортировка по возрастанию количества слова
     */
    public void sortingAmountAscending() {
        wordsArray.sort(comparing(Word::getAmount));
    }

    /**
     * Сортировка по убыванию количества слова
     */
    public void sortingAmountDescending() {
        wordsArray.sort(comparing(Word::getAmount).reversed());
    }

    /**
     * Выведение самого(ых) часто употребляемых слов
     */
    public void mostCommonWords() {
        sortingAmountDescending();
        int maxAmount = wordsArray.get(0).getAmount();
        int wordCounter = 0;
        for (int i = 0; i < wordsArray.size(); i++){
            wordCounter = wordCounter + wordsArray.get(i).getAmount();
        }
        System.out.println(wordCounter);
        for (int i = 0; i < wordsArray.size(); i++) {
            if (wordsArray.get(i).getAmount()==maxAmount) {
                System.out.println(i+1 + ". " +
                        "количество: " + wordsArray.get(i).getAmount() +
                        " | слово: " + wordsArray.get(i).getWord());
                System.out.println("Частота употребления: " + ((wordsArray.get(i).getAmount()*100)/wordCounter) + "%");
            }
            else {
                break;
            }
        }
    }


}
