package linked_list.singly_linked_list.social_media_connection;

public class Main {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        network.addUser(1, "Alice", 25);
        network.addUser(2, "Bob", 30);
        network.addUser(3, "Charlie", 22);
        network.addUser(4, "Diana", 28);

        network.addFriendConnection(1, 2);
        network.addFriendConnection(1, 3);
        network.addFriendConnection(2, 3);
        network.addFriendConnection(3, 4);

        network.displayFriends(1);
        network.findMutualFriends(1, 2);
        network.searchUser("Charlie");
        network.searchUser("3");
        network.countFriends();
    }
}
