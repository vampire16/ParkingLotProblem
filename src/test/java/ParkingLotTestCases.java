import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTestCases {
    Object vehicle = null;
    ParkingLotService parkingLotService = null;

    @Before
    public void setUp() throws Exception {
        vehicle = new Object();
        parkingLotService = new ParkingLotService();
    }

    @Test
    public void givenVehicle_WhenParked_ShouldReturnTrue() throws ParkingLotException {
        boolean isParked = parkingLotService.park(vehicle);
        Assert.assertTrue(isParked);
    }

    @Test
    public void givenVehicle_WhenAlreadyParked_ShouldReturnFalse() {
        try {
            parkingLotService.park(vehicle);
            parkingLotService.park(new Object());
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking lot is full",e.message);
        }
    }

    @Test
    public void givenVehicle_WhenUnParked_ShouldReturnTrue() throws ParkingLotException {
        parkingLotService.park(vehicle);
        boolean isUnParked = parkingLotService.unPark(vehicle);
        Assert.assertTrue(isUnParked);
    }

    @Test
    public void givenVehicle_WhenUnParkedWhichIsNotParked_ShouldReturnFalse() throws ParkingLotException {
        parkingLotService.park(vehicle);
        boolean isUnParked = parkingLotService.unPark(new Object());
        Assert.assertFalse(isUnParked);
    }
}
