package linked_list.doubly_linked_list.library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addAtEnd("1984", "George Orwell", "Dystopian", 1, true);
        library.addAtBeginning("To Kill a Mockingbird", "Harper Lee", "Classic", 2, true);
        library.addAtPosition(2, "The Hobbit", "J.R.R. Tolkien", "Fantasy", 3, false);

        library.displayForward();
        library.displayReverse();

        library.search("J.R.R. Tolkien");
        library.updateAvailability(3, true);
        library.removeByBookId(1);

        library.displayForward();
        library.countBooks();
    }
}

