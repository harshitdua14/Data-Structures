package linked_list.doubly_linked_list.undo_redo;

public class TextEditor {
    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Add new state
    public void type(String newText) {
        TextState newState = new TextState(newText);

        // Clear forward redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newState;
            size = 1;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
            tail = newState;
            size++;

            // If over history limit, remove oldest
            if (size > MAX_HISTORY) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }

        System.out.println("Typed: \"" + newText + "\"");
    }

    // Undo (go back one step)
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo -> Current Text: \"" + current.content + "\"");
        } else {
            System.out.println("Undo not available.");
        }
    }

    // Redo (go forward one step)
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo -> Current Text: \"" + current.content + "\"");
        } else {
            System.out.println("Redo not available.");
        }
    }

    // Show current state
    public void showCurrent() {
        if (current != null) {
            System.out.println("Current Text: \"" + current.content + "\"");
        } else {
            System.out.println("Editor is empty.");
        }
    }

    // Show full history (for debug/testing)
    public void showHistory() {
        System.out.println("History:");
        TextState temp = head;
        while (temp != null) {
            if (temp == current) {
                System.out.println("-> \"" + temp.content + "\" (current)");
            } else {
                System.out.println("   \"" + temp.content + "\"");
            }
            temp = temp.next;
        }
    }
}

