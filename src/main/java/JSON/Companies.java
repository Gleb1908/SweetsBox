package JSON;

import java.util.List;

public class Companies {

    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String inn;
    private String founded;
    private List<Securities> securities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public List<Securities> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Securities> securities) {
        this.securities = securities;
    }

}
