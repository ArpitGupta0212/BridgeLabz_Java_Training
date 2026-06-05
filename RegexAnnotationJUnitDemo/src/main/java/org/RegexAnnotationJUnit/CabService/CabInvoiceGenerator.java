package org.RegexAnnotationJUnit.CabService;

import java.lang.annotation.*;
import java.util.regex.Pattern;

@Retention(RetentionPolicy.RUNTIME)
@interface CabInfo{
    String service();
}

@CabInfo(service = "Cab Invoice Generator")
public class CabInvoiceGenerator {

    private static final double COST_PER_KM = 10;
    private static final double COST_PER_MIN = 1;
    private static final double MIN_FARE = 5;

    public double calculateFare(double distance,
                                int time){

        double fare =
                distance * COST_PER_KM +
                        time * COST_PER_MIN;

        return Math.max(fare,MIN_FARE);
    }

    public double calculateTotalFare(Ride[] rides){

        double total = 0;

        for(Ride ride : rides){
            total += calculateFare(
                    ride.distance,
                    ride.time
            );
        }

        return total;
    }

    public InvoiceSummary getSummary(
            Ride[] rides){

        double total =
                calculateTotalFare(rides);

        return new InvoiceSummary(
                rides.length,
                total,
                total/rides.length
        );
    }

    // Regex Example
    public boolean isValidUserId(
            String userId){

        return Pattern.matches(
                "[A-Z]{3}[0-9]{3}",
                userId
        );
    }
}