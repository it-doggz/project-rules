package com.itdoggz.projectrules.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status", "error"})
public class PayloadWithException {

    @JsonIgnore
    private final Exception exception;

    @JsonProperty("error")
    private final ErrorResponse error;

    public PayloadWithException(Exception exception) {
        this.exception = exception;
        this.error = ErrorResponse.defaultErrorResponse(exception);
    }

    @JsonGetter("status")
    public String getStatus() {
        return "Error";
    }

    public Exception exception() {
        return this.exception;
    }

}
