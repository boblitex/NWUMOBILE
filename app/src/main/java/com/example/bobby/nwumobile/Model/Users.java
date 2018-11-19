package com.example.bobby.nwumobile.Model;

public class Users {
    private String Name;
    private String password;
    private String tag;

    public Users() {
    }

    public Users(String Name, String password, String tag) {
        this.Name = Name;
        this.password = password;
        this.tag = tag;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}







