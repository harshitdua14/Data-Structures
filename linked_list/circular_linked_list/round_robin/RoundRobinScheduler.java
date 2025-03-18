package linked_list.circular_linked_list.round_robin;

public class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;

    // Add process at the end
    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    // Remove process by PID
    public void removeProcess(int pid) {
        if (head == null) return;

        Process curr = head, prev = tail;

        do {
            if (curr.pid == pid) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else {
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Display current queue
    public void displayQueue() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        System.out.println("Current Process Queue:");
        Process temp = head;
        do {
            System.out.println("PID: " + temp.pid + ", Remaining Time: " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate Round Robin Scheduling
    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        Process current = head;

        while (head != null) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= executionTime;
                currentTime += executionTime;

                // Update waiting and turnaround times
                Process temp = head;
                do {
                    if (temp != current && temp.remainingTime > 0) {
                        temp.waitingTime += executionTime;
                    }
                    temp = temp.next;
                } while (temp != head);

                System.out.println("\nProcess " + current.pid + " executed for " + executionTime + " units.");
                displayQueue();

                if (current.remainingTime == 0) {
                    current.turnaroundTime = currentTime;
                    System.out.println("Process " + current.pid + " completed at time " + currentTime);
                    int pidToRemove = current.pid;
                    current = current.next;
                    removeProcess(pidToRemove);

                    if (current == null || head == null) break;
                } else {
                    current = current.next;
                }
            } else {
                current = current.next;
            }
        }

        System.out.println("\nAll processes completed.\n");
        calculateAverageTimes();
    }

    // Calculate average waiting and turnaround times
    public void calculateAverageTimes() {
        if (head == null) return;

        int count = 0;
        int totalWT = 0, totalTAT = 0;
        Process temp = head;
        do {
            count++;
            totalWT += temp.waitingTime;
            totalTAT += temp.turnaroundTime;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Average Waiting Time: " + (float) totalWT / count);
        System.out.println("Average Turnaround Time: " + (float) totalTAT / count);
    }
}
