package com.example.fabrickproject.models;

public class Creditor {
    private String name;
    private Account account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Creditor{" +
                "name='" + name + '\'' +
                ", account=" + account +
                '}';
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
