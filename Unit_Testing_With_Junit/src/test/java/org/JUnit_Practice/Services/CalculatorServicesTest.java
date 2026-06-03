package org.JUnit_Practice.Services;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorServicesTest {
    @Test
    public void addTest(){
        int result = CalculatorServices.add(13,67);
        int expected=80;
        Assert.assertEquals(expected,result);
    }
    @Test
    public void productTest(){
        int result = CalculatorServices.product(2,17);
        int expected=34;
        Assert.assertEquals(expected,result);
    }
    @Test
    public void divideTest(){
        double result = CalculatorServices.divide(65.0,13.0);
        double expected=5.0;
        Assert.assertEquals(expected,result,0.0);
    }

}
