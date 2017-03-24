package services;

import java.util.ArrayList;

public class TestUsers {
    private static ArrayList<User> users = new ArrayList<>();
    static boolean u = User.addUser("Kenny", "adsf");
    
    public static void addUser(User user) {
	users.add(user);
    }

    public static User[] getUsers() {
	return users.toArray(new User[users.size()]);
    }
}
