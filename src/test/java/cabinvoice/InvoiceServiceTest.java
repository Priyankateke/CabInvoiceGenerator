package cabinvoice;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        InvoiceService invoiceService=new InvoiceService();
        double distance = 5.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(55, fare, 0.0);
    }
}
