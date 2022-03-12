package io.pera.garage.model;

import io.pera.garage.exception.BusinessValidationException;
import io.pera.garage.exception.BusinessValidationRule;
import lombok.Getter;

@Getter
public enum VehicleType {

    CAR(1), JEEP(2), TRUCK(4);

    private final int size;

    VehicleType(int size) {
        this.size = size;
    }

    public static VehicleType from(final String name) {
        for (VehicleType enumValue : values()) {
            if (enumValue.name().equalsIgnoreCase(name)) {
                return enumValue;
            }
        }
        throw new BusinessValidationException(BusinessValidationRule.VEHICLE_TYPE_NOT_FOUND);
    }

}