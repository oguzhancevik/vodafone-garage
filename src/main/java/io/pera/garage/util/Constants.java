package io.pera.garage.util;

import io.pera.garage.exception.BusinessValidationException;
import io.pera.garage.exception.BusinessValidationRule;
import lombok.Getter;

public class Constants {

    public static final class EXCEPTION {
        public static final String DEFAULT_CODE = "SYSTEM";
    }

    public static final class LIMIT {
        public static final int LEAVE_REQUEST_PARAMETER_COUNT = 2;
        public static final int PARK_REQUEST_PARAMETER_COUNT = 4;
        public static final int PARKING_SLOT_COUNT = 10;
    }

    public static final class MESSAGE {
        public static final String GARAGE_IS_FULL = "Garage is full!";
        public static final String GARAGE_IS_EMPTY = "Garage is empty!";
        public static final String ALLOCATED_SLOT = "Allocated %s slots!";
        public static final String VEHICLE_IS_OUT = "%s license plated vehicle is out";
    }

    @Getter
    public enum CommandType {

        PARK, LEAVE, STATUS;

        public static CommandType from(final String name) {
            for (CommandType enumValue : values()) {
                if (enumValue.name().equalsIgnoreCase(name)) {
                    return enumValue;
                }
            }
            throw new BusinessValidationException(BusinessValidationRule.COMMAND_TYPE_NOT_FOUND);
        }

    }

}
