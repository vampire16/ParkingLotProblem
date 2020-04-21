package com.bridgelabz.Exception;

public class ParkingLotException extends Exception {
    public Exception type;

    public ParkingLotException(Exception type) {
        this.type = type;
    }

    public enum Exception {
        LOT_IS_FULL,
        LOT_IS_EMPTY
    }
}
