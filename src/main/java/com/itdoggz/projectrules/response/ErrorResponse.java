package com.itdoggz.projectrules.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonPropertyOrder({"type", "message", "time"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ErrorResponse implements Cloneable {

    @JsonProperty("time")
    private String time;

    @JsonProperty("message")
    private String message;

    @JsonProperty("type")
    private String type;

    private ErrorResponse() {
    }

    public static ErrorResponseBuilder builder() {
        return new ErrorResponse().new ErrorResponseBuilder();
    }

    public static ErrorResponse defaultErrorResponse(Exception e) {
        return ErrorResponse.builder()
                .withMessage(e.getMessage())
                .withType(e instanceof ExceptionWithType eWithType ?
                        eWithType.getType() :
                        e.getClass().getSimpleName())
                .build();
    }

    public class ErrorResponseBuilder {

        private ErrorResponseBuilder() {
        }

        public ErrorResponseBuilder withMessage(String message) {
            ErrorResponse.this.message = message;
            return this;
        }

        public ErrorResponseBuilder withType(String type) {
            ErrorResponse.this.type = type;
            return this;
        }

        public ErrorResponseBuilder withTime(LocalDateTime time) {
            ErrorResponse.this.time = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss.SSS"));
            return this;
        }

        public ErrorResponse build() {
            try {
                return (ErrorResponse) ErrorResponse.this.clone();
            } catch (CloneNotSupportedException e) {
                return new ErrorResponse();
            }
        }

    }

}
