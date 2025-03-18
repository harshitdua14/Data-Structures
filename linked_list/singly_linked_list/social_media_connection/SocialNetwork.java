package linked_list.singly_linked_list.social_media_connection;

public class SocialNetwork {
    private User head = null;

    // Add a new user
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    // Find user by ID
    private User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection (bi-directional)
    public void addFriendConnection(int userId1, int userId2) {
        User u1 = findUserById(userId1);
        User u2 = findUserById(userId2);

        if (u1 == null || u2 == null || userId1 == userId2) {
            System.out.println("Invalid user IDs.");
            return;
        }

        if (!u1.friendIds.contains(userId2)) u1.friendIds.add(userId2);
        if (!u2.friendIds.contains(userId1)) u2.friendIds.add(userId1);

        System.out.println("Friend connection added between " + u1.name + " and " + u2.name);
    }

    // Remove friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        User u1 = findUserById(userId1);
        User u2 = findUserById(userId2);

        if (u1 != null && u2 != null) {
            u1.friendIds.remove(Integer.valueOf(userId2));
            u2.friendIds.remove(Integer.valueOf(userId1));
            System.out.println("Friend connection removed between " + u1.name + " and " + u2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int friendId : user.friendIds) {
            User friend = findUserById(friendId);
            if (friend != null) {
                System.out.println(" - " + friend.name + " (ID: " + friend.userId + ")");
            }
        }
    }

    // Find mutual friends
    public void findMutualFriends(int userId1, int userId2) {
        User u1 = findUserById(userId1);
        User u2 = findUserById(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("User(s) not found.");
            return;
        }

        System.out.println("Mutual friends between " + u1.name + " and " + u2.name + ":");
        for (int id : u1.friendIds) {
            if (u2.friendIds.contains(id)) {
                User mutual = findUserById(id);
                if (mutual != null) {
                    System.out.println(" - " + mutual.name + " (ID: " + mutual.userId + ")");
                }
            }
        }
    }

    // Search user by name or ID
    public void searchUser(String nameOrId) {
        try {
            int id = Integer.parseInt(nameOrId);
            User user = findUserById(id);
            if (user != null) {
                System.out.println("User found: " + user.name + " (ID: " + user.userId + ", Age: " + user.age + ")");
                return;
            }
        } catch (NumberFormatException e) {
            // Input was a name
            User temp = head;
            while (temp != null) {
                if (temp.name.equalsIgnoreCase(nameOrId)) {
                    System.out.println("User found: " + temp.name + " (ID: " + temp.userId + ", Age: " + temp.age + ")");
                    return;
                }
                temp = temp.next;
            }
        }

        System.out.println("User not found.");
    }

    // Count number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

