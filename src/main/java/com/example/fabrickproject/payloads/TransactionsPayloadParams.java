package com.example.fabrickproject.payloads;

import java.io.Serializable;

public class TransactionsPayloadParams implements Serializable {

    private String transactionId;
    private String operationId;
    private String accountingDate;
    private String valueDate;
private TransactionType type;
    private String enumeration;
    private String value;
    private String amount;
    private String currency;
    private String description;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(String accountingDate) {
        this.accountingDate = accountingDate;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }



    public String getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(String enumeration) {
        this.enumeration = enumeration;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{list:" +
                "transactionId='" + transactionId + '\'' +
                ", operationId='" + operationId + '\'' +
                ", accountingDate='" + accountingDate + '\'' +
                ", valueDate='" + valueDate + '\'' +
                type+
                ", enumeration='" + enumeration + '\'' +
                ", value='" + value + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
