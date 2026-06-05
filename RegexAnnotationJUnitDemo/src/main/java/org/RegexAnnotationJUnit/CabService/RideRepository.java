package org.RegexAnnotationJUnit.CabService;

public class RideRepository {

    public Ride[] getRides(String userId){

        return new Ride[]{

                new Ride(10,5),
                new Ride(5,2)
        };
    }
}