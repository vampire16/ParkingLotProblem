package com.bridgelabz.service;

import com.bridgelabz.Exception.ParkingLotException;
import com.bridgelabz.Observer.Observer;
import com.bridgelabz.Observer.Subject;
import com.bridgelabz.Utility.ParkingAttendant;
import com.bridgelabz.Utility.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ParkingLotService implements Subject {
    public int parkingCapacity;
    ArrayList<Observer> observers = new ArrayList<>();
    int counter = 0 ;
    HashMap<Integer, Object> lotMap;
    ParkingLot parkingLot;
    ParkingAttendant attendant = new ParkingAttendant() ;

    public ParkingLotService(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
        parkingLot = new ParkingLot(parkingCapacity);
        lotMap = parkingLot.initializeMap();
    }

    @Override
    public void register(Observer object) {
        observers.add(object);
    }

    @Override
    public void notifyObservers() {
        for (Iterator<Observer> iterator = observers.iterator(); iterator.hasNext(); ) {
            Observer o = iterator.next();
            o.sendParkingMessage(counter, this.parkingCapacity);
        }
    }

    public boolean park(Object vehicle) throws ParkingLotException {
        if (counter == this.parkingCapacity) {
            throw new ParkingLotException(ParkingLotException.Exception.LOT_IS_FULL);
        }
        lotMap = attendant.parkVehicle(vehicle, lotMap);
        counter++;
        this.notifyObservers();
        return true;
    }

    public boolean unPark(Object vehicle, Integer parkingSlot) throws ParkingLotException {
        if (lotMap.containsValue(vehicle)) {
            lotMap.put(parkingSlot, null);
            counter--;
            this.notifyObservers();
            if (counter == 0) {
                throw new ParkingLotException(ParkingLotException.Exception.LOT_IS_EMPTY);
            }
            return true;
        }
        return false;
    }
}
