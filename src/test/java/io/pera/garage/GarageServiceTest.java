package io.pera.garage;

import io.pera.garage.exception.BusinessValidationException;
import io.pera.garage.service.GarageService;
import io.pera.garage.util.Constants.MESSAGE;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GarageServiceTest {

    private GarageTestFactory testFactory;
    private GarageService garageService;

    @BeforeAll
    public void beforeAll() {
        testFactory = new GarageTestFactory();
        garageService = new GarageService(new ArrayList<>());
    }

    @Test
    public void invalidRequest() {
        String request = testFactory.invalidRequest();
        assertThrows(BusinessValidationException.class, () -> garageService.command(request));
    }

    @Test
    public void invalidCommandType() {
        String request = testFactory.invalidCommandType();
        assertThrows(BusinessValidationException.class, () -> garageService.command(request));
    }

    @Test
    public void invalidParkRequestParameterCount() {
        String request = testFactory.invalidParkRequestParameterCount();
        assertThrows(BusinessValidationException.class, () -> garageService.command(request));
    }

    @Test
    public void invalidVehicleType() {
        String request = testFactory.invalidVehicleType();
        assertThrows(BusinessValidationException.class, () -> garageService.command(request));
    }

    @Test
    @Order(1)
    public void garageIsEmpty() {
        String request = testFactory.statusCommand();
        assertEquals(MESSAGE.GARAGE_IS_EMPTY, garageService.command(request));
    }

    @Test
    @Order(2)
    public void parkCommand1() {
        String request = testFactory.parkCommand1();
        assertEquals(testFactory.parkCommand1Response(), garageService.command(request));
    }

    @Test
    @Order(3)
    public void parkCommand2() {
        String request = testFactory.parkCommand2();
        assertEquals(testFactory.parkCommand2Response(), garageService.command(request));
    }

    @Test
    @Order(4)
    public void parkCommand3() {
        String request = testFactory.parkCommand3();
        assertEquals(testFactory.parkCommand3Response(), garageService.command(request));
    }

    @Test
    @Order(5)
    public void parkCommand4() {
        String request = testFactory.parkCommand4();
        assertEquals(testFactory.parkCommand4Response(), garageService.command(request));
    }

    @Test
    @Order(6)
    public void leaveCommand() {
        String request = testFactory.leaveCommand();
        assertEquals(testFactory.leaveCommandResponse(), garageService.command(request));
    }

    @Test
    @Order(7)
    public void parkCommand5() {
        String request = testFactory.parkCommand5();
        assertEquals(testFactory.parkCommand5Response(), garageService.command(request));
    }

    @Test
    @Order(8)
    public void status() {
        String request = testFactory.statusCommand();
        assertEquals(testFactory.statusCommandResponse(), garageService.command(request));
    }

}
