package Bai3;

import Bai3.Authenticatable;

public class User implements Authenticatable {

    private String password;

    public User(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
