package com.example.fabrickproject.models;

import com.example.fabrickproject.payloads.BalancePayload;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BalanceResponse implements Serializable {
    @JsonProperty("status")
    private String status;
    @JsonProperty("error")
    private String[] error;
    @JsonProperty("payload")
private BalancePayload payload;


    public BalancePayload getBalancePayload() {
        return payload;
    }

    public void setBalancePayload(BalancePayload payload) {
        this.payload = payload;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String []getError() {
        return error;
    }

    public void setError(String []error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "BalanceResponse{" +
                "status='" + status + '\'' +
                ", error=" + Arrays.toString(error) +
                ", balancePayload=" + payload +
                '}';
    }
}
