import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {
    public int parkingCapacity;
    public List list = new ArrayList();

    public ParkingLotService(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
    }

    public boolean park(Object vehicle) throws ParkingLotException {
        if (list.size() == this.parkingCapacity) {
            Owner.ParkingLotInfo = "Parking lot is full";
            AirportSecurity.ParkingLotInfo = "Parking lot is full";
            throw new ParkingLotException("Parking lot is full");
        }
        list.add(vehicle);
        return true;

    }

    public boolean unPark(Object vehicle) throws ParkingLotException {
        if (list.contains(vehicle)) {
            list.remove(vehicle);
            if (list.size() == 0) {
                Owner.ParkingLotInfo = "Parking lot is empty";
                throw new ParkingLotException("Parking lot is empty");
            }
            return true;
        }
        return false;
    }
}
