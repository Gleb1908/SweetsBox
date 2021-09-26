package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        Root root = mapper.readValue(new File("src/main/resources/Companies.json"), Root.class);

        //Вывод всех имеющихся компаний в формате "Краткое название - компания. Дата основания: дата"
        System.out.println("Вывод всех имеющихся компаний");
        root.printCompanyName();
        System.out.println("======================");

        //Вывод всех ценных бумаг, которые просрочены на текущий день, а также
        //посчитано суммарное число всех таких бумаг.
        System.out.println("Вывод всех ценных бумаг");
        root.printOverdueSecurities();
        System.out.println("======================");

        //Выведение названия и даты создания всех организаций, основанных после введенной даты
        //в одном из форматов: "ДД.ММ.ГГГГ", "ДД.ММ,ГГ", "ДД/ММ/ГГГ", "ДД.ММ.ГГ"
        System.out.println("Выведение названия и даты создания всех организаций, основанных после введенной даты");
        root.recentCompanies("21.08,95");
        System.out.println("======================");

        //Выведение id компании и коды ценных бумаг, использующих валюту,
        //которая указана пользователем: "EU", "USD", "RUB"
        System.out.println("Выведение id компании и коды ценных бумаг, использующих указанную валюту");
        root.foreignExchangeSecurities("EU");
        System.out.println("======================");

    }

}
