public class MovieTicketData implements IMovieTickets {
    public String movieName;
    public int numberOfTickets;
    public double ticketPrice;

    public MovieTicketData(String movieName, int numberOfTickets, double ticketPrice) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        return 0;
    }

    @Override
    public boolean ValidateData(MovieTicketData movieTicketData) {
        return false;
    }
}
