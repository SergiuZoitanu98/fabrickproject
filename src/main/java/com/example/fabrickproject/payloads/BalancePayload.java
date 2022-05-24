package com.example.fabrickproject.payloads;

import java.io.Serializable;

public class BalancePayload implements Serializable {

   private String date;
    private String  balance;
    private String  availableBalance;
    private String currency;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Payload:{" +
                "date:'" + date + '\'' +
                ", balance:'" + balance + '\'' +
                ", availableBalance:'" + availableBalance + '\'' +
                ", currency:'" + currency + '\'' +
                '}';
    }
}
