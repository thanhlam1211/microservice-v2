package com.udemy.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {
    @Schema(
            description = "API path invoked by client",
            example = "/accounts/create"
    )
    private String apiPath;

    @Schema(
            description = "Error code representing the error happened",
            example = "400"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message representing the error happened",
            example = "Bad Request"
    )
    private String errorMessage;

    @Schema(
            description = "Error time ",
            example = "2022-01-01T00:00:00"
    )
    private LocalDateTime errorTime;
}
