package linked_list.circular_linked_list.online_ticket;

public class Main {
    public static void main(String[] args) {
        TicketSystem system = new TicketSystem();

        system.addTicket("T001", "Alice", "Avengers", "A1", "10:00 AM");
        system.addTicket("T002", "Bob", "Avengers", "A2", "10:00 AM");
        system.addTicket("T003", "Charlie", "Inception", "B1", "12:00 PM");

        system.displayTickets();

        System.out.println("\nSearching for movie 'Avengers':");
        system.searchByMovie("Avengers");

        System.out.println("\nRemoving ticket T002:");
        system.removeTicket("T002");

        system.displayTickets();

        System.out.println("\nTotal tickets booked: " + system.countTickets());
    }
}

