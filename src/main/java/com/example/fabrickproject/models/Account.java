package com.example.fabrickproject.models;

public class Account {
private String accountCode;

    public String getAccountCode() {
        return accountCode;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountCode='" + accountCode + '\'' +
                '}';
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }
}
