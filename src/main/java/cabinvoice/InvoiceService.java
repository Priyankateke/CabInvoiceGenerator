package cabinvoice;

public class InvoiceService {
    private static double RS_PER_KILOMETER = 10;
    private static int RS_PER_MINUTE = 1;

    public double calculateFare(double distance, int time) {
        return RS_PER_KILOMETER * distance + RS_PER_MINUTE * time;
    }
}
