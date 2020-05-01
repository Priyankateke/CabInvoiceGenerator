package cabinvoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

    InvoiceService invoiceService;
    @Before
    public void setUp() {
        invoiceService=new InvoiceService();
    }

    /** Given distance and time should return total fare*/
    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        double distance = 5.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(55.0, fare, 0.0);
    }

    /** Given distance and time, if total fare is less than minimum fare should return minimum fare*/
    @Test
    public void givenDistanceAndTime_WhenTotalFareLessThanMinimumFare_shouldReturnMinimumFare() {
        double distance = 0.3;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5.0, fare,0.0);
    }

    /** given distance and time of multiple rides should return multiple fare*/
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummery() {
        Ride[] rides = {new Ride(2.0,5), new Ride(0.1,1)};
        InvoiceSummery invoiceSummery = invoiceService.calculateFare(rides);
        InvoiceSummery expectedInvoiceSummery = new InvoiceSummery(2,30);
        Assert.assertEquals(invoiceSummery,expectedInvoiceSummery);
    }
}
