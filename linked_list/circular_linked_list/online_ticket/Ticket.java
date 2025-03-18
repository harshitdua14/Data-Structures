package linked_list.circular_linked_list.online_ticket;

class Ticket {
    String ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;

    Ticket next;

    public Ticket(String ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
