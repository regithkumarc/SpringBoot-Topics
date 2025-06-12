package com.example.orderservice.exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ErrorResponse {
    private int statusCode;
    private String statusMessage;
    private long timestamp;
}
