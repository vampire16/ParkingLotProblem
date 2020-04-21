package com.bridgelabz.service;

import com.bridgelabz.Exception.ParkingLotException;
import com.bridgelabz.Observer.Observer;
import com.bridgelabz.Observer.Subject;

import java.util.ArrayList;
import java.util.Iterator;

public class ParkingLotService implements Subject {
   ArrayList list = new ArrayList();
    public int parkingCapacity;
    ArrayList<Observer> observers = new ArrayList<>();
    int counter = 0 ;
//    HashMap<Integer, Object> lotMap;
//    ParkingPlot parkingPlot;
//    ParkingAttendant attendant;

    public ParkingLotService(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
//        parkingPlot = new ParkingPlot(parkingCapacity);
//        lotMap = parkingPlot.initializeMap();
    }

    @Override
    public void register(Observer object) {
        observers.add(object);
    }

    @Override
    public void notifyObservers() {
        for (Iterator<Observer> iterator = observers.iterator(); iterator.hasNext(); ) {
            Observer o = iterator.next();
            o.sendParkingMessage(list.size(), this.parkingCapacity);
        }
    }

    public boolean park(Object vehicle) throws ParkingLotException {
        if (counter == this.parkingCapacity) {
            throw new ParkingLotException(ParkingLotException.Exception.LOT_IS_FULL);
        }
        list.add(vehicle);
        counter++;
        this.notifyObservers();
        return true;
    }

    public boolean unPark(Object vehicle) throws ParkingLotException {
        if (list.contains(vehicle)) {
            list.remove(vehicle);
            counter--;
            if (counter == 0) {
                throw new ParkingLotException(ParkingLotException.Exception.LOT_IS_EMPTY);
            }
            this.notifyObservers();
            return true;
        }
        return false;
    }
}
