package linked_list.circular_linked_list.task_scheduler;

public class TaskScheduler {
    private Task head = null;
    private Task current = null; // For round-robin viewing

    // Add at beginning
    public void addAtBeginning(int taskId, String name, int priority, String dueDate) {
        Task newTask = new Task(taskId, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    // Add at end
    public void addAtEnd(int taskId, String name, int priority, String dueDate) {
        Task newTask = new Task(taskId, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, int taskId, String name, int priority, String dueDate) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(taskId, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, name, priority, dueDate);
        Task temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove by Task ID
    public void removeById(int taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    if (head.next == head) {
                        head = null;
                        current = null;
                    } else {
                        Task last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task removed: " + taskId);
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found: " + taskId);
    }

    // View current task and move to next
    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }
        displayTask(current);
        current = current.next;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        System.out.println("Tasks in Scheduler:");
        Task temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    // Utility method to print task
    private void displayTask(Task t) {
        System.out.println("ID: " + t.taskId + ", Name: " + t.taskName + ", Priority: " + t.priority + ", Due: " + t.dueDate);
    }
}

