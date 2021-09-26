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

    /**
     * Вывод всех имеющихся компаний в формате "Краткое название - компания. Дата основания: дата"
     */
    public void printCompanyName() {
        for (Companies companies: companies) {
            System.out.println("Краткое название - " + companies.getName().toString() +
                    ". Дата основания: " + companies.getFounded().toString());
        }
    }

    /**
     * Вывод всех ценных бумаг, которые просрочены на текущий день, а также
     * посчитано суммарное число всех таких бумал.
     * Вывод: код ценной бумаги, дата истечения, полное наименование организации-владельца
     */
    public void printOverdueSecurities() throws ParseException {
        int count = 0;
        for (Companies companies: companies) {
            for (Securities securities: companies.getSecurities()){
                if (new SimpleDateFormat("dd.MM.yyyy").parse(securities.getDate()).before(new Date())) {
                    System.out.println("Код ценной бумаги - " + securities.getCode() +
                            ". Дата истечения: " + securities.getDate() +
                            ". Полное название организации-владельца: " + companies.getName());
                    count++;
                }
            }
        }
        System.out.println("Суммарное число просроченных бумаг: " + count);
    }

    /**
     *  Выведение названия и даты создания всех организаций, основанных после введенной даты
     *  в одном из форматов: "ДД.ММ.ГГГГ", "ДД.ММ,ГГ", "ДД/ММ/ГГГ", "ДД.ММ.ГГ"
    **/
    public void recentCompanies(String date) throws ParseException {
        date = date.replace(",", ".").replace("/",".");


    }

    /**
     * Выведение id компании и коды ценных бумаг, использующих валюту,
     * которая указана пользователем: "EU", "USD", "RUB"
    **/
    public void foreignExchangeSecurities(String curr) throws IOException {
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
