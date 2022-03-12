package io.pera.garage.util;

import io.pera.garage.exception.BusinessValidationException;
import io.pera.garage.exception.BusinessValidationRule;
import io.pera.garage.model.Vehicle;
import io.pera.garage.model.VehicleType;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;
import java.util.StringJoiner;

import static io.pera.garage.util.Constants.CommandType;
import static io.pera.garage.util.Constants.LIMIT.*;

public class GarageUtils {

    public static void validateRequest(String request) {
        if (StringUtils.isBlank(request))
            throw new BusinessValidationException(BusinessValidationRule.INVALID_REQUEST);
    }

    public static String[] splitCommands(String request) {
        return request.split(StringUtils.SPACE);
    }

    public static CommandType validateCommandType(String commandTypeString) {
        return CommandType.from(commandTypeString);
    }

    public static void validateLeaveRequest(String[] commands) {
        if (commands.length != LEAVE_REQUEST_PARAMETER_COUNT)
            throw new BusinessValidationException(BusinessValidationRule.INVALID_LEAVE_REQUEST_PARAMETER_COUNT);

        if (!NumberUtils.isParsable(commands[1]))
            throw new BusinessValidationException(BusinessValidationRule.LEAVE_REQUEST_SECOND_PARAMETER_MUST_BE_NUMBER);
    }

    public static void validateParkRequest(String[] commands) {
        if (commands.length != PARK_REQUEST_PARAMETER_COUNT)
            throw new BusinessValidationException(BusinessValidationRule.INVALID_PARK_REQUEST_PARAMETER_COUNT);
    }

    public static VehicleType validateVehicleType(String vehicleTypeString) {
        return VehicleType.from(vehicleTypeString);
    }

    public static boolean isNotAvailableSlot(List<Vehicle> vehicles, VehicleType vehicleType) {
        if (CollectionUtils.isNotEmpty(vehicles)) {
            long availableSlotCount = vehicles.stream().mapToInt(v -> v.getType().getSize() + 1).sum();
            return availableSlotCount + vehicleType.getSize() >= PARKING_SLOT_COUNT;
        }
        return false;
    }

    public static void setVehicleAllocatedSlots(List<Vehicle> vehicles, Vehicle vehicle) {
        if (vehicles.isEmpty()) vehicle.setAllocatedSlots(0);
        else vehicle.setAllocatedSlots(getLastUsedSlotIndex(vehicles));
    }

    public static int getLastUsedSlotIndex(List<Vehicle> vehicles) {
        Vehicle lastVehicle = vehicles.get(vehicles.size() - 1);
        List<Integer> lastAllocatedSlots = lastVehicle.getAllocatedSlots();
        return lastAllocatedSlots.get(lastAllocatedSlots.size() - 1);
    }

    public static String getVehicleParkedSlots(Vehicle vehicle) {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < vehicle.getAllocatedSlots().size() - 1; i++) {
            stringJoiner.add(String.valueOf(vehicle.getAllocatedSlots().get(i)));
        }
        return stringJoiner.toString();
    }

}
