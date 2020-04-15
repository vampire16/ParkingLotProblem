public class ParkingLotException extends Exception {

    String message;

    public ParkingLotException(String message) {
        this.message = message;
    }
}
