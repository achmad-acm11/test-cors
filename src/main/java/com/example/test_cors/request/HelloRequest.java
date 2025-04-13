package com.example.test_cors.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HelloRequest {
    @JsonProperty("message")
    private String message;
}
