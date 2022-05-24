package com.example.fabrickproject.models;

import com.example.fabrickproject.payloads.TransactionPayload;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class TransactionResponse implements Serializable {
    @JsonProperty("status")
    private String status;
    @JsonProperty("errors")
    private String [] errors;
    @JsonProperty("payload")
    private TransactionPayload payload;

    public TransactionPayload getTransactionPayload() {
        return payload;
    }

    public void setTransactionPayload(TransactionPayload transactionPayload) {
        this.payload = transactionPayload;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }


    @Override
    public String toString() {
        return "TransactionResponse{" +
                "status='" + status + '\'' +
                ", errors=" + Arrays.toString(errors) +
                ", transactionPayload=" + payload +
                '}';
    }
}
