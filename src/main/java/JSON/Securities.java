package JSON;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Securities {

    private String name;
    private List<Currency> currency;
    private String code;
    private LocalDate date;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String name) { this.name = name; }

    @JsonProperty("currency")
    public List<Currency> getCurrency() { return currency; }
    @JsonProperty("currency")
    public void setCurrency(List<Currency> currency) { this.currency = currency; }

    @JsonProperty("code")
    public String getCode() { return code; }
    @JsonProperty("code")
    public void setCode(String code) { this.code = code; }

    @JsonProperty("date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    public LocalDate getDate() { return date; }

    public String getFormated(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    @JsonProperty("date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    public void setDate(LocalDate date) { this.date = date; }

}
