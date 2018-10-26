
package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum LoanPaymentFrequency {

    @JsonProperty("WEEKLY")
    WEEKLY("WEEKLY"),
    @JsonProperty("BIWEEKLY")
    BIWEEKLY("BIWEEKLY"),
    @JsonProperty("TWICEMONTHLY")
    TWICEMONTHLY("TWICEMONTHLY"),
    @JsonProperty("MONTHLY")
    MONTHLY("MONTHLY"),
    @JsonProperty("FOURWEEKS")
    FOURWEEKS("FOURWEEKS"),
    @JsonProperty("BIMONTHLY")
    BIMONTHLY("BIMONTHLY"),
    @JsonProperty("QUARTERLY")
    QUARTERLY("QUARTERLY"),
    @JsonProperty("SEMIANNUALLY")
    SEMIANNUALLY("SEMIANNUALLY"),
    @JsonProperty("ANNUALLY")
    ANNUALLY("ANNUALLY"),
    @JsonProperty("OTHER")
    OTHER("OTHER");
    private final String value;
    private final static Map<String, LoanPaymentFrequency> VALUE_CACHE = new HashMap<String, LoanPaymentFrequency>();

    static {
        for (LoanPaymentFrequency c: values()) {
            VALUE_CACHE.put(c.value, c);
        }
    }

    private LoanPaymentFrequency(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static LoanPaymentFrequency fromValue(String value) {
        return VALUE_CACHE.get(value);
    }

    @Override
    public String toString() {
        return this.value;
    }

}
