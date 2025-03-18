package linked_list.circular_linked_list.round_robin;

class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;

    int waitingTime = 0;
    int turnaroundTime = 0;

    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}
