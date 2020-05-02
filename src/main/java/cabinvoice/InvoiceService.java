package cabinvoice;

public class InvoiceService {

    RideRepository rideRepository = new RideRepository();

   public void setRideRepository(RideRepository rideRepository) {
       this.rideRepository = rideRepository;
   }

    public InvoiceSummery getTotalFare(Ride[] rides) {
        double totalFare = 0;
        for(Ride ride:rides)
            totalFare += ride.cabRide.calculateCostOfRide(ride);
        return new InvoiceSummery(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummery getInvoiceSummery(String userId) {
        return this.getTotalFare(rideRepository.getRides(userId));
    }
}
