package com.rtt.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceResponse implements IDomain {

    private static final long serialVersionUID = 1L;

    @JsonProperty("response_code")
    private String responseCode;

    @JsonProperty("response_description")
    private String responseDescription;


    @JsonIgnore
    private DECISION decision = DECISION.FAIL;

    public enum DECISION {
        SUCCESS,
        FAIL
    }


    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {

        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;

    }

    public void setDecision(DECISION decision) {
        this.decision = decision;

    }

    public DECISION getDecision() {
        return this.decision;

    }

    /**
     * Checks if is success.
     *
     * @return the decision
     */

    @JsonIgnore
    public boolean isSuccess() {
        return (decision == DECISION.SUCCESS) ? true : false;
    }
}