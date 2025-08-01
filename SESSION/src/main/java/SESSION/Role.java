package SESSION;

public class Role {
    private int roleId;
    private String roleName;
    private String description;
    private int recommendedUsers;
    
    public Role() {}
    
    public Role(int roleId, String roleName, String description, int recommendedUsers) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.description = description;
        this.recommendedUsers = recommendedUsers;
    }
    
    // Getters and Setters
    public int getRoleId() {
        return roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    public String getRoleName() {
        return roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getRecommendedUsers() {
        return recommendedUsers;
    }
    
    public void setRecommendedUsers(int recommendedUsers) {
        this.recommendedUsers = recommendedUsers;
    }
}