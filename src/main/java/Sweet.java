public abstract class Sweet {
    private String name;
    private int weight;
    private int price;
    private int id;

    public Sweet (String name, int weight, int price, int id){
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.id = id;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
