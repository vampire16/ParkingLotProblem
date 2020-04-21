package com.bridgelabz.Utility;//package com.bridgelabz.Utility;
//
import java.util.HashMap;

public class ParkingLot {

    private final int parkingCapacity;
    public HashMap<Integer, Object> lotMap;

    public ParkingLot(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
    }

    public HashMap<Integer, Object> initializeMap(){
        lotMap = new HashMap<>();
        for (int i = 1; i<=parkingCapacity; i++){
            lotMap.put(i, null);
        }
        return lotMap;
    }
}
