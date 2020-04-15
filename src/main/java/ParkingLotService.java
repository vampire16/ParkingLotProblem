public class ParkingLotService {
    private Object vehicle;

    public boolean park(Object vehicle) {
        if(this.vehicle != null)
            return false;
        this.vehicle = vehicle;
        return true;
    }

    public boolean unPark(Object vehicle) {
        if(this.vehicle == vehicle){
            this.vehicle = null;
            return true;
        }
        return false;
    }
}
