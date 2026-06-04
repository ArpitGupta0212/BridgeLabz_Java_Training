package org.JUnit_Practice.Services;


import org.junit.*;

import java.util.Date;

public class CalculatorServicesTest {
    int count=0;
    @BeforeClass
    public  static void init(){
        System.out.println("Before all test cases");
        System.out.println("Started Test "+new Date());
    }
    @Before
    public void beforeEachTestCase(){
        count=0;
        System.out.println("Before each test case");
    }
    @Test(timeout = 2000)
    public void addTest(){
        for(int i=0;i<20;i++){
            count+=i;
        }
        System.out.println("Add Test Run");
        int result = CalculatorServices.add(13,67);
        int expected=80;
        System.out.println(count);
        Assert.assertEquals(expected,result);
    }
    @Test
    public void productTest(){
        for(int i=0;i<40;i++){
            count+=i;
        }
        System.out.println("Product Test Run");
        int result = CalculatorServices.product(2,17);
        int expected=34;
        System.out.println(count);
        Assert.assertEquals(expected,result);
    }
    @Test
    public void divideTest(){
        for(int i=0;i<50;i++){
            count+=i;
        }
        System.out.println("Divide Test Run");
        double result = CalculatorServices.divide(65.0,13.0);
        double expected=5.0;
        System.out.println(count);
        Assert.assertEquals(expected,result,0.0);
    }
    @After
    public void afterEachTestCase(){
        System.out.println("After Each Test cases");
    }
    @AfterClass
    public static void cleanup(){
        System.out.println("After All Test Cases "+new Date());
    }
}
