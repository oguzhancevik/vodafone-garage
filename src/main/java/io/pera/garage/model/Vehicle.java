package io.pera.garage.model;

import io.pera.garage.util.GarageUtils;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.SPACE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vehicle {

    String licensePlate;

    String colour;

    VehicleType type;

    @Builder.Default
    List<Integer> allocatedSlots = new ArrayList<>();

    public void setAllocatedSlots(int startingIndex) {
        for (int i = startingIndex + 1; i <= startingIndex + 1 + type.getSize(); i++)
            allocatedSlots.add(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(licensePlate, vehicle.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate);
    }

    @Override
    public String toString() {
        return licensePlate + SPACE + colour + SPACE + GarageUtils.getVehicleParkedSlots(this);
    }

}
