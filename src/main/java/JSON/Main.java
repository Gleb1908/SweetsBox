package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        ObjectMapper mapper = new ObjectMapper();
        Root root = mapper.readValue(new File("src/main/resources/Companies.json"), Root.class);
        root.printCompanyName();

    }

}
