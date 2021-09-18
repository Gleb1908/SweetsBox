package JSON;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String jsonSource = "";

        try {
            JsonNode node = JacksonParser.parse(jsonSource);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
