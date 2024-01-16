package org.andrey.api.pojo;

public class UpdateUserPassword {
    private String password;

    public UpdateUserPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}