package io.pera.garage.service;

import io.pera.garage.model.Vehicle;
import io.pera.garage.util.Constants.CommandType;
import io.pera.garage.util.Constants.MESSAGE;
import io.pera.garage.util.GarageUtils;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.pera.garage.util.Constants.MESSAGE.GARAGE_IS_EMPTY;

@Service
@AllArgsConstructor
public class GarageService {

    List<Vehicle> vehicles;

    public String command(String request) {
        GarageUtils.validateRequest(request);

        var commands = GarageUtils.splitCommands(request);

        var commandType = GarageUtils.validateCommandType(commands[0]);

        String response;
        if (commandType == CommandType.STATUS)
            response = status();
        else if (commandType == CommandType.LEAVE)
            response = leave(commands);
        else
            response = park(commands);

        return response;
    }

    private String status() {
        StringBuilder response = new StringBuilder();

        vehicles.forEach(v -> response.append(v).append(System.lineSeparator()));

        return StringUtils.isNotBlank(response) ? response.toString() : GARAGE_IS_EMPTY;
    }

    private String leave(String[] commands) {
        GarageUtils.validateLeaveRequest(commands);

        Vehicle vehicle = vehicles.remove(Integer.parseInt(commands[1]) - 1);

        return String.format(MESSAGE.VEHICLE_IS_OUT, vehicle.getLicensePlate());
    }

    public String park(String[] commands) {
        GarageUtils.validateParkRequest(commands);

        var vehicleType = GarageUtils.validateVehicleType(commands[3]);

        if (GarageUtils.isNotAvailableSlot(vehicles, vehicleType))
            return MESSAGE.GARAGE_IS_FULL;

        var vehicle = Vehicle.builder()
                .licensePlate(commands[1])
                .colour(commands[2])
                .type(vehicleType)
                .build();

        GarageUtils.setVehicleAllocatedSlots(vehicles, vehicle);

        vehicles.add(vehicle);

        return String.format(MESSAGE.ALLOCATED_SLOT, vehicleType.getSize());
    }

}
