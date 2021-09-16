package SortingWordsTask;

public class Word {

    private String word;
    private int amount;

    public Word(String word, int amount) {
        this.word = word;
        this.amount = amount;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void plusAmount() {
        this.amount = this.amount + 1;
    }

}
