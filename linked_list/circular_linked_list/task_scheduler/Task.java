package linked_list.circular_linked_list.task_scheduler;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;

    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

