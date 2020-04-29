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

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        double distance = 5.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(55.0, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenTotalFareLessThanMinimumFare_shouldReturnMinimumFare() {
        double distance = 0.3;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5.0, fare,0.0);
    }
}
