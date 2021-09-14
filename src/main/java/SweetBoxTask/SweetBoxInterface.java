package SweetBoxTask;

public interface SweetBoxInterface {

    public void addSweet(Sweet object);
    public void removeSweetByIndex(int index);
    public void removeLastSweet();
    public int weightSweetBox();
    public int priceSweetBox();
    public void allSweetBoxInfo();
    public void smartRemovalByWeigth(int weigth);
    public void smartRemovalByPrice(int price);
}
