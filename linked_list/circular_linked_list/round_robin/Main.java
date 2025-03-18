package linked_list.circular_linked_list.round_robin;

public class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Add processes: pid, burst time, priority
        scheduler.addProcess(1, 5, 2);
        scheduler.addProcess(2, 3, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 6, 2);

        // Simulate with time quantum
        int timeQuantum = 3;
        scheduler.simulate(timeQuantum);
    }
}

