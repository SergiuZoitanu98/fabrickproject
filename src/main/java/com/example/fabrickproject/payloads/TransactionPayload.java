package com.example.fabrickproject.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class TransactionPayload  implements Serializable {
    @JsonProperty("list")
    private List<TransactionsPayloadParams> transactionsPayloadParams;

    public List<TransactionsPayloadParams> getTransactionsPayloadParams() {
        return transactionsPayloadParams;
    }

    public void setTransactionsPayloadParams(List<TransactionsPayloadParams> list) {
        this.transactionsPayloadParams = list;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "TransactionsPayloadParams" + transactionsPayloadParams +
                '}';
    }
}