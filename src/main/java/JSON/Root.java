package JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Root {

    private List<Companies> companies;

    @JsonProperty("companies")
    public List<Companies> getCompanies() {return companies;}

    @JsonProperty("companies")
    public void setCompanies(List<Companies> companies) {
        this.companies = companies;
    }

}
