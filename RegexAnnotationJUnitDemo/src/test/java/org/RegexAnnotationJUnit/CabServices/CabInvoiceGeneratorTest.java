package org.RegexAnnotationJUnit.CabServices;

import org.RegexAnnotationJUnit.CabService.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator generator =
            new CabInvoiceGenerator();

    @Test
    public void givenDistanceAndTime(){

        assertEquals(
                105,
                generator.calculateFare(
                        10,
                        5
                ),
                0.0
        );
    }

    @Test
    public void givenMultipleRides(){

        Ride[] rides = {

                new Ride(10,5),
                new Ride(5,2)
        };

        assertEquals(
                157,
                generator.calculateTotalFare(
                        rides
                ),
                0.0
        );
    }

    @Test
    public void testRegex(){

        assertTrue(
                generator.isValidUserId(
                        "ABC123"
                )
        );
    }
}