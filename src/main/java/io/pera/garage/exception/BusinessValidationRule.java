package io.pera.garage.exception;

import io.pera.garage.util.Constants.EXCEPTION;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum BusinessValidationRule {

    INVALID_REQUEST("VGS-001", "Invalid request!"),
    COMMAND_TYPE_NOT_FOUND("VGS-002", "Command type not found!"),
    VEHICLE_TYPE_NOT_FOUND("VGS-003", "Vehicle type not found!"),
    INVALID_LEAVE_REQUEST_PARAMETER_COUNT("VGS-004", "Invalid leave request parameter count!"),
    LEAVE_REQUEST_SECOND_PARAMETER_MUST_BE_NUMBER("VGS-005", "Leave request second parameter must be number!"),
    INVALID_PARK_REQUEST_PARAMETER_COUNT("VGS-006", "Invalid park request parameter count!");

    String code = EXCEPTION.DEFAULT_CODE;
    String message;
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST; // use only 4XX and 5XX codes

    BusinessValidationRule(String code, String message) {
        this.code = code;
        this.message = message;
    }

    BusinessValidationRule(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
