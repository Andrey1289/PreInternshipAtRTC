package org.andrey.api.pojo;

public class RegisterUser {
    private final String login;
    private final String pass;
    public RegisterUser(String login, String pass) {
        if(login == null || login.trim().isEmpty()){
            throw new IllegalArgumentException("Login cannot be null or empty");
        }
        if(pass == null || pass.trim().isEmpty()){
            throw new IllegalArgumentException("Pass cannot be null or empty");
        }
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }
}
