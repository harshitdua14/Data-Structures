package linked_list.circular_linked_list.task_scheduler;

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(101, "Backup Files", 1, "2025-03-11");
        scheduler.addAtBeginning(102, "Send Emails", 2, "2025-03-10");
        scheduler.addAtPosition(2, 103, "System Update", 3, "2025-03-15");

        scheduler.displayAllTasks();
        scheduler.viewCurrentTask(); // Show 1st task
        scheduler.viewCurrentTask(); // Show 2nd task

        scheduler.searchByPriority(2);

        scheduler.removeById(103);
        scheduler.displayAllTasks();
    }
}

