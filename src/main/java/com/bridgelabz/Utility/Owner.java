package com.bridgelabz.Utility;

import com.bridgelabz.Observer.Observer;

import java.util.HashMap;

public class Owner implements Observer {
    public static String parkingLotInfo = null;
    HashMap<Integer, Object> lotMap;

    @Override
    public void sendParkingMessage(int parkedVehicleCount, int parkingCapacity) {
        if (parkedVehicleCount >= parkingCapacity)
            parkingLotInfo = "Parking lot is full";
        else
            parkingLotInfo = "Parking lot is empty";
    }

//    public void getUpdatedMap(HashMap<Integer, Object> lotMap) {
//        this.lotMap = lotMap;
//    }
//
//    public Integer decideParkingSlot() {
//        for (int i=1;i<=lotMap.size(); i++) {
//            if (lotMap.get(i) == null)
//                return i;
//        }
//        return null;
//    }
}
