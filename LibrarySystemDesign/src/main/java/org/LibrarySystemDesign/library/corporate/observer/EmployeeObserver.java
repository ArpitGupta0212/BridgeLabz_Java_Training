package org.LibrarySystemDesign.library.corporate.observer;

public class EmployeeObserver {
    private String latestAlert;

    public void update(String msg) {
        latestAlert = msg;
    }

    public String getLatestAlert() {
        return latestAlert;
    }
}
