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
    public void givenVehicle_WhenPark_ShouldReturnTrue() {
        boolean isPark = parkingLotService.park(vehicle);
        Assert.assertTrue(isPark);
    }
}
