package com.bridgelabz.Utility;

import com.bridgelabz.Observer.Observer;

public class AirportSecurity implements Observer {
    public static String parkingLotInfo = null;

    @Override
    public void sendParkingMessage(int parkedVehicleCount, int parkingCapacity) {
        if (parkedVehicleCount >= parkingCapacity)
            parkingLotInfo = "Parking lot is full";
    }
}
