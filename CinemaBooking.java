class CinemaBooking {
    String movieName;
    String customerName;
    double ticketPrice;
    int numberOfTickets;

    
    CinemaBooking(String customerName, String movieName,
                  double ticketPrice, int numberOfTickets) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    
    CinemaBooking(String customerName, String movieName) {
        this(customerName, movieName, 200.0, 0);
    }

    
    void bookTickets(int tickets) {
        numberOfTickets = tickets;
        displayBooking();
    }

    
    void bookTickets(int tickets, double price) {
        numberOfTickets = tickets;
        ticketPrice = price;
        displayBooking();
    }

    
    void displayBooking() {
        System.out.println("\nCustomer Name   : "
                + customerName.toUpperCase());
        System.out.println("Movie Name      : "
                + movieName.toUpperCase());

        if (numberOfTickets <= 0) {
            System.out.println("Booking Status  : Invalid number of tickets");
            return;
        }

        double totalAmount = ticketPrice * numberOfTickets;
        double discount = 0;

        if (numberOfTickets >= 5) {
            discount = totalAmount * 0.10;
        }

        double finalAmount = totalAmount - discount;

        System.out.printf("Ticket Price    : Rs. %.2f%n", ticketPrice);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Booking Status  : Booking Successful");
        System.out.printf("Total Amount    : Rs. %.2f%n", totalAmount);
        System.out.printf("Discount        : Rs. %.2f%n", discount);
        System.out.printf("Final Amount    : Rs. %.2f%n", finalAmount);
    }

    
    boolean compareCustomer(CinemaBooking other) {
        return this.customerName.equalsIgnoreCase(other.customerName);
    }

    public static void main(String[] args) {
        System.out.println("========== CINEMA TICKET BOOKING ==========");

        
        CinemaBooking b1 =
                new CinemaBooking("Sneha", "Avatar", 200.0, 5);
        b1.displayBooking();

        
        CinemaBooking b2 =
                new CinemaBooking("Arjun", "Avatar");
        b2.bookTickets(2);

        
        System.out.println("\nSame Customer: "
                + b1.compareCustomer(b2));
    }
}
