package linked_list.circular_linked_list.online_ticket;

public class TicketSystem {
    private Ticket head = null;

    // Add new ticket at the end
    public void addTicket(String ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head; // circular link
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("Ticket booked for " + customerName);
    }

    // Remove ticket by ID
    public void removeTicket(String ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = null;

        do {
            if (current.ticketID.equals(ticketID)) {
                if (current == head && current.next == head) {
                    head = null; // only one ticket
                } else {
                    if (current == head) {
                        Ticket last = head;
                        while (last.next != head) last = last.next;
                        head = head.next;
                        last.next = head;
                    } else {
                        previous.next = current.next;
                    }
                }
                System.out.println("Ticket with ID " + ticketID + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket ID not found: " + ticketID);
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("Booked Tickets:");
        Ticket temp = head;
        do {
            displayTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Customer Name
    public void searchByCustomer(String customerName) {
        boolean found = false;
        Ticket temp = head;

        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found for customer: " + customerName);
        }
    }

    // Search by Movie Name
    public void searchByMovie(String movieName) {
        boolean found = false;
        Ticket temp = head;

        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found for movie: " + movieName);
        }
    }

    // Count total tickets
    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    // Utility method to print a ticket
    private void displayTicket(Ticket t) {
        System.out.println("TicketID: " + t.ticketID + ", Customer: " + t.customerName +
                ", Movie: " + t.movieName + ", Seat: " + t.seatNumber + ", Time: " + t.bookingTime);
    }
}

