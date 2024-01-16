package org.andrey.api;

public class UserToken {
    private String password;
    private String username;

    public UserToken(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
