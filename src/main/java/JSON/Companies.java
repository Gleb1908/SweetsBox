package JSON;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Companies {

    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String inn;
    private LocalDate founded;
    private List<Securities> securities;

    @JsonProperty("id")
    public int getId() { return id; }
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }
    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("inn")
    public String getInn() {
        return inn;
    }
    @JsonProperty("inn")
    public void setInn(String inn) {
        this.inn = inn;
    }

    @JsonProperty("founded")
    @JsonFormat(pattern = "dd.MM.yyyy")
    public LocalDate getFounded() {
        return founded;
    }
    @JsonProperty("founded")
    @JsonFormat(pattern = "dd.MM.yyyy")
    public void setFounded(LocalDate founded) {
        this.founded = founded;
    }

    public String getFormated(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return founded.format(formatter);
    }

    @JsonProperty("securities")
    public List<Securities> getSecurities() {
        return securities;
    }
    @JsonProperty("securities")
    public void setSecurities(List<Securities> securities) {
        this.securities = securities;
    }

}
