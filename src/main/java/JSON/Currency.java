package JSON;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Currency {
    EU, RUB, USD;

    @JsonValue
    public String toValue() {
        switch (this) {
            case EU: return "EU";
            case RUB: return "RUB";
            case USD: return "USD";
        }
        return null;
    }

    @JsonCreator
    public static Currency forValue(String value) throws IOException {
        if (value.equals("EU")) return EU;
        if (value.equals("RUB")) return RUB;
        if (value.equals("USD")) return USD;
        throw new IOException("Cannot deserialize Currency");
    }
}