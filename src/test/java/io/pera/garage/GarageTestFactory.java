package io.pera.garage;

import io.pera.garage.util.Constants.MESSAGE;

public class GarageTestFactory {

    public String invalidRequest() {
        return "";
    }

    public String invalidCommandType() {
        return "my-test-command";
    }

    public String invalidParkRequestParameterCount() {
        return "park 34-SO-1988";
    }

    public String invalidVehicleType() {
        return "park 34-SO-1988 Black SUV";
    }

    public String statusCommand() {
        return "status";
    }

    public String parkCommand1() {
        return "park 34-SO-1988 Black Car";
    }

    public String parkCommand1Response() {
        return "Allocated 1 slots!";
    }

    public String parkCommand2() {
        return "park 34-BO-1987 Red Truck";
    }

    public String parkCommand2Response() {
        return "Allocated 4 slots!";
    }

    public String parkCommand3() {
        return "park 34-VO-2018 Blue Jeep";
    }

    public String parkCommand3Response() {
        return "Allocated 2 slots!";
    }

    public String parkCommand4() {
        return "park 34-HBO-2020 Black Truck";
    }

    public String parkCommand4Response() {
        return MESSAGE.GARAGE_IS_FULL;
    }

    public String leaveCommand() {
        return "leave 3";
    }

    public String leaveCommandResponse() {
        return "34-VO-2018 license plated vehicle is out";
    }

    public String parkCommand5() {
        return "park 34-LO-2000 White Car";
    }

    public String parkCommand5Response() {
        return "Allocated 1 slots!";
    }

    public String statusCommandResponse() {
        return "34-SO-1988 Black [1]\n" +
                "34-BO-1987 Red [3,4,5,6]\n" +
                "34-LO-2000 White [8]\n";
    }

}
