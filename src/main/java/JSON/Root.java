package JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
     * посчитано суммарное число всех таких бумаг.
     * Вывод: код ценной бумаги, дата истечения, полное наименование организации-владельца
     */
    public void printOverdueSecurities() throws ParseException {
        int count = 0;
        for (Companies companies: companies) {
            for (Securities securities: companies.getSecurities()){
                if (securities.getDate().isBefore(LocalDate.now())) {
                    System.out.println(". Полное название организации-владельца: " + companies.getName() +
                            ". Дата истечения: " + securities.getFormated("dd.MM.yyyy") +
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
        // Проверка регулярным выражением, что введенная дата указана в заданном формате:
        // 2 числа (дата), "." или "/", 2 числа (месяц), ".", "," или "/", 2 или 4 числа (год)
        if (date.matches("[\\d]{2}[\\.\\/][\\d]{2}[\\.\\/\\,][\\d]{2,4}")) {
            String dateLine = date.replace(",", ".").replace("/", ".");
            StringBuffer sb = new StringBuffer(dateLine);
            // проверка на длину строки, если строка менее 8 символов, значит дата указана
            // с годом в сокращенном виде (пример: 27.09.21)
            if (sb.length() == 8) {
                // Если год в сокращенном виде, проверяется первая цифра года, и если она в диапазоне
                // от 5 до 9, то это будет 1900 года, и прибавляется "19" к строке перед сокращенным значением года
                if (Character.getNumericValue(sb.charAt(6)) > 4 && Character.getNumericValue(sb.charAt(6)) <= 9) {
                    sb.insert(6, "19");
                    //Если от 0 до 4, то это будет 2000 года, и прибавляется "20"
                } else if (Character.getNumericValue(sb.charAt(6)) >= 0 && Character.getNumericValue(sb.charAt(6)) <= 4) {
                    sb.insert(6, "20");
                }
            }
            String str = sb.toString();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate localDate = LocalDate.parse(str, formatter);
            for (Companies companies: companies) {
                if (companies.getFounded().isAfter(localDate)) {
                    System.out.println("Полное название организации-владельца: " + companies.getName() +
                            ". Дата основания: " + companies.getFormated("dd.MM.yyyy"));
                }
            }
        }
            else {
                System.out.println("Формат даты указан не верно!");
            }
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
