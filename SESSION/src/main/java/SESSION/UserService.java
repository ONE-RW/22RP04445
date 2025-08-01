package SESSION;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static Map<String, User> users = new HashMap<>();
    private static Map<Integer, Role> roles = new HashMap<>();
    
    static {
        // Initialize roles based on the provided table
        roles.put(1, new Role(1, "System Admin", "Full control: users, news, events, settings", 2));
        roles.put(2, new Role(2, "Sports Editor", "Manages sports news and events", 2));
        roles.put(3, new Role(3, "Academic Editor", "Publishes academic news, lectures, deadlines", 2));
        roles.put(4, new Role(4, "Campus Life Editor", "Updates about dorms, clubs, social activities", 1));
        roles.put(5, new Role(5, "Events Coordinator", "Adds/edits events (all categories)", 1));
        roles.put(6, new Role(6, "Tech Editor", "Posts about tech updates, labs, innovations", 1));
        
        // Initialize sample users for each role
        users.put("admin", new User(1, "admin", "admin123", "admin@university.edu", roles.get(1)));
        users.put("sports_editor", new User(2, "sports_editor", "sports123", "sports@university.edu", roles.get(2)));
        users.put("academic_editor", new User(3, "academic_editor", "academic123", "academic@university.edu", roles.get(3)));
        users.put("campus_editor", new User(4, "campus_editor", "campus123", "campus@university.edu", roles.get(4)));
        users.put("events_coord", new User(5, "events_coord", "events123", "events@university.edu", roles.get(5)));
        users.put("tech_editor", new User(6, "tech_editor", "tech123", "tech@university.edu", roles.get(6)));
    }
    
    public static User authenticateUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    
    public static Role getRoleById(int roleId) {
        return roles.get(roleId);
    }
    
    public static Map<Integer, Role> getAllRoles() {
        return roles;
    }
    
    public static Map<String, User> getAllUsers() {
        return users;
    }
}