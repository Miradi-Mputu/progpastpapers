import java.io.FileWriter;
import java.io.IOException;

public class MovieTickets implements IMovieTickets {
    private String movieName;
    private int numberOfTickets;
    private double ticketPrice;

    public MovieTickets() {
        // empty constructor for save button
    }

    public MovieTickets(String movieName, int numberOfTickets, double ticketPrice) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
    }

    public boolean validateData(String movieName, int numberOfTickets, double ticketPrice) {
        if (movieName == null || movieName.isEmpty()) {
            return false;
        }
        if (numberOfTickets <= 0 || ticketPrice <= 0) {
            return false;
        }
        return true;
    }

    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        double vat = 0.15;
        return numberOfTickets * ticketPrice * (1 + vat);
    }

    @Override
    public boolean ValidateData(MovieTicketData movieTicketData) {
        return false;
    }

    public void saveReportToFile(String report) throws IOException {
        try (FileWriter writer = new FileWriter("report.txt")) {
            writer.write(report);
        }
    }
}
