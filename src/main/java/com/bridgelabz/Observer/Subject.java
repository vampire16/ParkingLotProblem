package com.bridgelabz.Observer;

public interface Subject {
    void register(Observer obj);

    void notifyObservers();
}
