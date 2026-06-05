package org.RegexAnnotationJUnit.CabService;

public class InvoiceSummary {

    int totalRides;
    double totalFare;
    double averageFare;

    public InvoiceSummary(int totalRides,
                          double totalFare,
                          double averageFare) {

        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    @Override
    public String toString() {

        return "Total Rides : " + totalRides +
                "\nTotal Fare : " + totalFare +
                "\nAverage Fare : " + averageFare;
    }
}