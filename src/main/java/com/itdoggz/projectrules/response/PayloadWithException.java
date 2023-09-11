package com.itdoggz.projectrules.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonPropertyOrder({"status", "result"})
public class PayloadWithException {

    @JsonIgnore
    private final Exception exception;

    private final ErrorResponse error;

    public PayloadWithException(Exception exception) {
        this.exception = exception;
        this.error = ErrorResponse.builder()
                .withMessage(exception.getMessage())
                .withType(exception instanceof ExceptionWithType eWithType ?
                        eWithType.getType() :
                        exception.getClass().getSimpleName())
                .build();
    }

    @JsonGetter("status")
    public String getStatus() {
        return "Error";
    }

    public Exception exception() {
        return this.exception;
    }

    @JsonGetter("error")
    public ErrorResponse error() {
        return this.error;
    }

    @JsonPropertyOrder({"type", "message", "time"})
    public final static class ErrorResponse {

        private final String time = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss.SSS"));

        public String message;

        public String type;


        private ErrorResponse() {
        }

        public static ErrorResponseBuilder builder() {
            return new ErrorResponse().new ErrorResponseBuilder();
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

            public ErrorResponse build() {
                return ErrorResponse.this;
            }

        }

        public String getTime() {
            return time;
        }

        public String getMessage() {
            return message;
        }

        public String getType() {
            return type;
        }

    }

}
