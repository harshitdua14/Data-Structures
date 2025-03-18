package linked_list.doubly_linked_list.undo_redo;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.type("Hello");
        editor.type("Hello, World");
        editor.type("Hello, World!");
        editor.type("Hello, Universe!");

        editor.showCurrent();
        editor.undo();
        editor.undo();
        editor.showCurrent();

        editor.redo();
        editor.showCurrent();

        editor.type("New Text After Undo");
        editor.showHistory();
    }
}
