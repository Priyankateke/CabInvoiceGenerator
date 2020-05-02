package cabinvoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

    private InvoiceService invoiceService;
    private RideRepository rideRepository;
    private  Ride[] rides = null;
    InvoiceSummery expectedInvoiceSummery;

    @Before
    public void initialize() {
        invoiceService=new InvoiceService();
        rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
        rides = new Ride[] {
                new Ride(CabRide.NORMAL,2.0,5),
                new Ride(CabRide.PREMIUM,0.1,1)};
        expectedInvoiceSummery = new InvoiceSummery(2,45.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummery() {
        InvoiceSummery invoiceSummery = invoiceService.getTotalFare(rides);
        Assert.assertEquals(invoiceSummery,expectedInvoiceSummery);
    }

    @Test
    public void givenUserId_shouldReturnInvoiceSummery() {
        String userId = "priyanka1";
        invoiceService.addRides(userId,rides);
        InvoiceSummery invoiceSummery = invoiceService.getInvoiceSummery(userId);
        Assert.assertEquals(invoiceSummery,expectedInvoiceSummery);
    }
}
