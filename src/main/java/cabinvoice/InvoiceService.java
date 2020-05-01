package cabinvoice;

public class InvoiceService {
    private static double RS_PER_KILOMETER = 10;
    private static int RS_PER_MINUTE = 1;
    private static double MINIMUM_FARE = 5;

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
}
