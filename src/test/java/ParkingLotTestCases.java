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
    public void givenVehicle_WhenParked_ShouldReturnTrue() {
        boolean isParked = parkingLotService.park(vehicle);
        Assert.assertTrue(isParked);
    }

    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldInformOwner() {
        parkingLotService.park(vehicle);
        parkingLotService.park(car);
        parkingLotService.park(bus);
        Assert.assertEquals("Parking lot is full", Owner.ParkingLotInfo);
    }

    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldInformAirportSecurity() {
        parkingLotService.park(vehicle);
        parkingLotService.park(car);
        parkingLotService.park(bus);
        Assert.assertEquals("Parking lot is full", AirportSecurity.ParkingLotInfo);
    }

    @Test
    public void givenVehicle_WhenUnParked_ShouldReturnTrue() {
        parkingLotService.park(vehicle);
        parkingLotService.park(car);
        boolean isUnParked = parkingLotService.unPark(vehicle);
        Assert.assertTrue(isUnParked);
    }

    @Test
    public void givenVehicle_WhenUnParkedWhichIsNotParked_ShouldReturnFalse() {
        parkingLotService.park(vehicle);
        parkingLotService.park(car);
        boolean isUnParked = parkingLotService.unPark(bus);
        Assert.assertFalse(isUnParked);
    }
}
