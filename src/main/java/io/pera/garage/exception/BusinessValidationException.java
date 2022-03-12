package io.pera.garage.exception;

import lombok.Getter;

@Getter
public class BusinessValidationException extends RuntimeException {

    private final BusinessValidationRule validationRule;

    public BusinessValidationException(BusinessValidationRule validationRule) {
        super(validationRule.getMessage());
        this.validationRule = validationRule;
    }

}
