package viewmodel;

public class User {
    private String username;
    private String password;
    private Boolean enable;
    public String getUsername() {
        return username;
    }
    public void setUsername(String  username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    public Boolean getEnable() {
        return enable;
    }
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}