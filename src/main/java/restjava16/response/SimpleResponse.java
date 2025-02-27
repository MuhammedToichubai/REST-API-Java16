package restjava16.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
public class SimpleResponse {
    private String message;
    private HttpStatus status;
}
