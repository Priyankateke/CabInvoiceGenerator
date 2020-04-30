package cabinvoice;

public class InvoiceService {
    private static double RS_PER_KILOMETER = 10;
    private static int RS_PER_MINUTE = 1;
    private static double MINIMUM_FARE = 5;

    /** Calculating total fare*/
    public double calculateFare(double distance, int time) {
        double totalFare = RS_PER_KILOMETER * distance + RS_PER_MINUTE * time;

        //If TOTAL_FARE is less than MINIMUM_FARE should return MINIMUM_FARE
        if(totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    /** Calculating total fare for multiple rides*/
    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for(Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
