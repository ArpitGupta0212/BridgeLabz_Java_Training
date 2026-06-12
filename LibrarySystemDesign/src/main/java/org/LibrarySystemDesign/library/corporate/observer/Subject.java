package org.LibrarySystemDesign.library.corporate.observer;

import java.util.*;

public class Subject {
    private ArrayList<EmployeeObserver> observers = new ArrayList<>();
    private String statusMessage;
    public void addObserver(EmployeeObserver obs) {
        observers.add(obs);
    }
    private void notifyObservers() {
        for(EmployeeObserver observer : observers) {
            observer.update(statusMessage);
        }
    }
    public void updateLicenseStatus(String status) {
        statusMessage = status;
        notifyObservers();
    }
}
