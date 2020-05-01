package cabinvoice;

public class InvoiceService {
    private final double RS_PER_KILOMETER = 10;
    private final int RS_PER_MINUTE = 1;
    private final double MINIMUM_FARE = 5;
    private RideRepository rideRepository;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

    /** Calculating total fare*/
    public double calculateFare(double distance, int time) {
        double totalFare = RS_PER_KILOMETER * distance + RS_PER_MINUTE * time;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /** Calculating total fare for multiple rides*/
    public InvoiceSummery calculateFare(Ride[] rides) {
        double totalFare = 0;
        for(Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummery(rides.length,totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummery getInvoiceSummery(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
