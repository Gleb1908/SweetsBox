package JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Root {

    private List<Companies> companies;

    @JsonProperty("companies")
    public List<Companies> getCompanies() {return companies;}

    @JsonProperty("companies")
    public void setCompanies(List<Companies> companies) {
        this.companies = companies;
    }

    public void print(){
        System.out.println(companies);
    }

    public void printCompanyName() {
        for (Companies companies: companies) {
            System.out.println("Краткое название - " + companies.getName().toString() +
                    ". Дата основания: " + companies.getFounded().toString());
        }
    }

    public void printOverdueSecurities() throws ParseException {
        int count = 0;
        for (Companies companies: companies) {
            for (Securities securities: companies.getSecurities()){
                if (new SimpleDateFormat("dd.MM.yyyy").parse(securities.getDate()).before(new Date())) {
                    System.out.println("Код ценной бумаги - " + securities.getCode() +
                            ". Дата истечения: " + securities.getDate() +
                            ". Полное название организации владельца: " + companies.getName());
                    count++;
                }
            }
        }
        System.out.println("Суммарное число просроченных бумаг: " + count);
    }

    public void recentCompanies(String date) throws ParseException {
        date = date.replace(",", ".").replace("/",".");


    }

    public void foreignExchangeSecurities(String curr) throws IOException {
        int count = 0;
        for (Companies companies : companies) {
            for (int j = 0; j < companies.getSecurities().size(); j++) {
                for (Currency currency : companies.getSecurities().get(j).getCurrency()) {
                    if (companies.getSecurities().get(j).getCurrency().contains(currency.forValue(curr))) {
                        System.out.println("ID компании - " + companies.getId() +
                                ". Код ценной бумаги - " + companies.getSecurities().get(j).getCode());
                        break;
                    }
                }
            }
        }
    }

}
