import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {
    private Object vehicle;
    public int parkingCapacity;
    public List list=new ArrayList();

    public ParkingLotService(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
    }

    public boolean park(Object vehicle) {
        if (list.size() == this.parkingCapacity) {
            Owner.ParkingLotInfo = "Parking lot is full";
            AirportSecurity.ParkingLotInfo = "Parking lot is full";
        } else {
            list.add(vehicle);
            return true;
        }
        return false;
    }

    public boolean unPark(Object vehicle) {
        if (list.contains(vehicle)) {
            list.remove(vehicle);
            return true;
        }
        return false;
    }
}
