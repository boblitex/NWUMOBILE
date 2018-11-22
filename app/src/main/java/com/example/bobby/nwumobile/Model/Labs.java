package com.example.bobby.nwumobile.Model;

public class Labs {
    private String Labname;
    private int NumberOfPcs;
    private long CurrentUsers;

    public Labs() {
    }

    public Labs(long currentUsers, String labname, int numberOfPcs) {
        this.CurrentUsers = currentUsers;
        this.Labname = labname;
        this.NumberOfPcs = numberOfPcs;
    }

    public long getCurrentUsers() {
        return CurrentUsers;
    }

    public void setCurrentUsers() {
        setCurrentUsers();
    }

    public void setCurrentUsers(long currentUsers) {
        this.CurrentUsers = currentUsers;
    }

    public String getLabname() {
        return Labname;
    }

    public void setLabname(String labname) {
        this.Labname = labname;
    }

    public int getNumberOfPcs() {
        return NumberOfPcs;
    }

    public void setNumberOfPcs(int numberOfPcs) {
        this.NumberOfPcs = numberOfPcs;
    }
}
