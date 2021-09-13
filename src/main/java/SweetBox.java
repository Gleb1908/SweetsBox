import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SweetBox implements SweetBoxInterface{

    private ArrayList<Sweet> sweetBox = new ArrayList<>();

    Sweet twix = new CandyBar("Twix", 55, 38, 101) {};
    Sweet snikers = new CandyBar("Snikers", 51, 40, 102) {};
    Sweet mars = new CandyBar("Mars", 50, 39, 103) {};
    Sweet bounty = new CandyBar("Bounty", 58, 39, 104) {};
    Sweet nesquik = new Chocolate("Nesquik", 100, 90, 105) {};
    Sweet ritterSport = new Chocolate("Ritter Sport", 100, 152, 106) {};
    Sweet dove = new Chocolate("Dove", 90, 127, 107) {};
    Sweet schogetten = new Chocolate("Schogetten", 100, 137, 108) {};
    Sweet toffifee = new Candies("Toffifee", 125, 183, 109) {};
    Sweet lindor = new Candies("Lindor", 125, 338, 110) {};
    Sweet raffaello = new Candies("Raffaello", 40, 99, 111) {};
    Sweet ferreroRocher = new Candies("Ferrero Rocher", 300, 788, 112) {};
    Sweet milka = new Cookie("Milka", 168, 166, 113) {};
    Sweet oreo = new Cookie("Oreo", 228, 138, 114) {};
    Sweet chocoPie = new Cookie("Choco Pie", 360, 174, 115) {};
    Sweet tuc = new Cookie("Tuc", 100, 69, 116) {};

    @Override
    public void addSweet(Sweet object) {
        sweetBox.add(object);
    }

    @Override
    public void removeSweetByIndex(int index) {
        sweetBox.remove(index-1);
    }

    @Override
    public void removeLastSweet() {
        sweetBox.remove(sweetBox.size()-1);
    }

    @Override
    public int weightSweetBox() {
        int countWeight = 0;
        for(Sweet element : sweetBox) {
            countWeight = countWeight + element.getWeight();
        }
        return countWeight;
    }

    @Override
    public int priceSweetBox() {
        int countPrice = 0;
        for(Sweet element : sweetBox) {
            countPrice = countPrice + element.getPrice();
        }
        return countPrice;
    }

    @Override
    public void allSweetBoxInfo() {
        for(Sweet element : sweetBox) {
            System.out.println("Название: " + element.getName() +
                    ", вес: " + element.getWeight() +
                    ", стоимость: " + element.getPrice());
        }
    }

    private int maxSweetWheigthInTheBox() {
        int maxWeight = 0;
        for(Sweet element : sweetBox) {
            if (maxWeight < element.getWeight()) {
                maxWeight = element.getWeight();
            }
            else {
                continue;
            }
        }
        return maxWeight;
    }

    private int indexOfMinSweetWheigthInTheBox() {

        int minWeight = maxSweetWheigthInTheBox();
        int indexOfSweet = 0;
        for (int i = 0; i < sweetBox.size(); i++) {
            if (minWeight > sweetBox.get(i).getWeight()) {
                minWeight = sweetBox.get(i).getWeight();
                indexOfSweet = i+1;
            } else
                continue;
        }
        return indexOfSweet;
    }

    @Override
    public void smartRemovalByWeigth(int requiredWeigth) {
        if (requiredWeigth < maxSweetWheigthInTheBox()) {
            System.out.println("Самая тяжелая сладость весит больше введенного значения");
        }
        else {
            while (requiredWeigth < weightSweetBox()) {
                removeSweetByIndex(indexOfMinSweetWheigthInTheBox());
            }
        }
    }

    private int maxSweetPriceInTheBox() {
        int maxPrice = 0;
        for(Sweet element : sweetBox) {
            if (maxPrice < element.getWeight()) {
                maxPrice = element.getWeight();
            }
            else {
                continue;
            }
        }
        return maxPrice;
    }

    private int indexOfMinSweetPriceInTheBox() {

        int minPrice = maxSweetPriceInTheBox();
        int indexOfSweet = 0;
        for (int i = 0; i < sweetBox.size(); i++) {
            if (minPrice > sweetBox.get(i).getPrice()) {
                minPrice = sweetBox.get(i).getPrice();
                indexOfSweet = i+1;
            } else
                continue;
        }
        return indexOfSweet;
    }

    @Override
    public void smartRemovalByPrice(int requiredPrice) {
        if (requiredPrice < maxSweetPriceInTheBox()) {
            System.out.println("Самая дорогая сладость стоит больше введенного значения");
        }
        else {
            while (requiredPrice < priceSweetBox()) {
                removeSweetByIndex(indexOfMinSweetPriceInTheBox());
            }
        }
    }


}
