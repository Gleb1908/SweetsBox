package JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Securities {

    private String name;
    private List<Currency> currency;
    private String code;
    private String date;

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
    public String getDate() { return date; }
    @JsonProperty("date")
    public void setDate(String date) { this.date = date; }

}
