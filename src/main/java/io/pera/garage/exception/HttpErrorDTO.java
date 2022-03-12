package io.pera.garage.exception;

import io.pera.garage.util.Constants.EXCEPTION;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HttpErrorDTO {

    @Builder.Default
    String code = EXCEPTION.DEFAULT_CODE;

    String message;

}
