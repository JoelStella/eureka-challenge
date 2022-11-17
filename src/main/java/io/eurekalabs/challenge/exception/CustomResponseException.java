package io.eurekalabs.challenge.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CustomResponseException extends RuntimeException {

    private final HttpStatus status;
    private final String reason;

    public CustomResponseException(HttpStatus status, String reason) {
        super(reason);
        this.status = status;
        this.reason = reason;
    }

}
