package services;

import java.util.ArrayList;

public class TestUsers {
    private static ArrayList<User> users = new ArrayList<>();
    
    public static void addUser(User user) {
	users.add(user);
    }

    public static User[] getUsers() {
	return users.toArray(new User[users.size()]);
    }

    public static User deleteUser(String name) {
	for (int i = 0, length = users.size(); i < length; ++i)
	    if (users.get(i).getName().equals(name))
		return users.remove(i);
	return null;
    }

    public static User getUser(String name) {
	for(int i = 0, length = users.size(); i < length; ++i)
	    if(users.get(i).getName().equals(name))
		return users.get(i);
	return null;
    }
}

