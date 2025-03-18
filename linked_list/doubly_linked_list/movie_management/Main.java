package linked_list.doubly_linked_list.movie_management;

public class Main {
	public static void main(String[]args) {
		MovieList list = new MovieList();

        list.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        list.addAtBeginning("The Matrix", "Lana Wachowski", 1999, 8.7);
        list.addAtPosition(2, "Interstellar", "Christopher Nolan", 2014, 8.6);
        list.addAtEnd("Fight Club", "David Fincher", 1999, 8.8);

        list.displayForward();
        System.out.println();
        list.displayReverse();

        System.out.println();
        list.searchByDirector("Christopher Nolan");
        list.searchByRating(8.8);

        list.updateRating("Fight Club", 9.0);
        list.removeByTitle("Interstellar");

        System.out.println();
        list.displayForward();
	}
}
