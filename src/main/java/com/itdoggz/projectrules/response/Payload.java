package com.itdoggz.projectrules.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status", "result"})
public record Payload<T>(T result) {

    @JsonGetter("status")
    public String getStatus() {
        return "Success";
    }

}
