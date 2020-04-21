import com.bridgelabz.Exception.ParkingLotException;
import com.bridgelabz.Utility.AirportSecurity;
import com.bridgelabz.Utility.Owner;
import com.bridgelabz.service.ParkingLotService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTestCases {
    Object vehicle = null;
    Object car = null;
    Object bus = null;
    ParkingLotService parkingLotService = null;


    @Before
    public void setUp() {
        vehicle = new Object();
        car = new Object();
        bus = new Object();
        parkingLotService = new ParkingLotService(2);
    }

    @Test
    public void givenVehicle_WhenParked_ShouldReturnTrue() throws ParkingLotException {
        boolean isParked = parkingLotService.park(vehicle);
        Assert.assertTrue(isParked);
    }

    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldInformOwner() {
        Owner owner = new Owner();
        parkingLotService.register(owner);
        try {
            parkingLotService.park(vehicle);
            parkingLotService.park(car);
            parkingLotService.park(bus);
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking lot is full", Owner.parkingLotInfo);
        }
    }

    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldInformAirportSecurity() {
        AirportSecurity airportSecurity = new AirportSecurity();
        parkingLotService.register(airportSecurity);
        try {
            parkingLotService.park(vehicle);
            parkingLotService.park(car);
            parkingLotService.park(bus);
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking lot is full", AirportSecurity.parkingLotInfo);
        }
    }

    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldThrowException() {
        try {
            parkingLotService.park(vehicle);
            parkingLotService.park(car);
            parkingLotService.park(bus);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.Exception.LOT_IS_FULL, e.type);
        }
    }

    @Test
    public void givenVehicle_WhenUnParked_ShouldReturnTrue() throws ParkingLotException {
        parkingLotService.park(vehicle);
        parkingLotService.park(car);
        boolean isUnParked = parkingLotService.unPark(vehicle);
        Assert.assertTrue(isUnParked);
    }

    @Test
    public void givenVehicle_WhenUnParkedWhichIsNotParked_ShouldReturnFalse() throws ParkingLotException {
        parkingLotService.park(vehicle);
        parkingLotService.park(car);
        boolean isUnParked = parkingLotService.unPark(bus);
        Assert.assertFalse(isUnParked);
    }

    @Test
    public void givenVehicle_WhenUnParkedAllVehicle_ShouldInformOwner() {
        Owner owner = new Owner();
        parkingLotService.register(owner);
        try {
            parkingLotService.park(vehicle);
            parkingLotService.park(car);
            parkingLotService.unPark(vehicle);
            parkingLotService.unPark(car);
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking lot is empty", Owner.parkingLotInfo);
        }
    }

    @Test
    public void givenVehicle_WhenUnParkedAllVehicle_ShouldThrowException() {
        try {
            parkingLotService.park(vehicle);
            parkingLotService.park(car);
            parkingLotService.unPark(vehicle);
            parkingLotService.unPark(car);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.Exception.LOT_IS_EMPTY, e.type);
        }
    }
}
