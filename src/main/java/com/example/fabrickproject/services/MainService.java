package com.example.fabrickproject.services;
import com.example.fabrickproject.models.*;
import com.example.fabrickproject.payloads.BalancePayload;
import com.example.fabrickproject.payloads.TransactionPayload;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class MainService {
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    private final String ACCOUNT_ID ="14537780";
    private final String API_KEY = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
    private final String AUTH_SCHEMA ="S2S";
    public BalancePayload getBalance() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Auth-Schema", AUTH_SCHEMA);
        httpHeaders.set("Api-Key",API_KEY);
        httpHeaders.set("X-Time-Zone","Europe/Rome");
        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<BalanceResponse> responsee = restTemplate.exchange(
                "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/"+ ACCOUNT_ID +"/balance", HttpMethod.GET, requestEntity, BalanceResponse.class);
        return responsee.getBody().getBalancePayload();
    }
    public String createMoneyTransfer() throws HttpClientErrorException, IOException, InterruptedException {
       String json = "{creditor:{name:'John Doe',account:{accountCode:'IT23A0336844430152923804660',bicCode:'SELBIT2BXXX'},address:{address:null,city:null,countryCode:null}},executionDate:'2019-04-01',uri:REMITTANCE_INFORMATION,description:'Payment invoice 75/2017',amount:0.01,currency:'EUR',isUrgent:false,isInstant:false,feeType:'SHA',feeAccountId:'45685475',taxRelief:{taxReliefId:'L449',isCondoUpgrade:false,creditorFiscalCode:'56258745832',beneficiaryType:'NATURAL_PERSON',naturalPersonBeneficiary:{fiscalCode1:'MRLFNC81L04A859L',fiscalCode2:null,fiscalCode3:null,fiscalCode4:null,fiscalCode5:null},legalPersonBeneficiary:{fiscalCode:null,legalRepresentativeFiscalCode:null}}}";
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(jsonObject)))
                .uri(URI.create("https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/"+ ACCOUNT_ID +"/payments/money-transfers"))
                .setHeader("Api-Key",API_KEY)
                .setHeader("Auth-Schema", AUTH_SCHEMA)
                .setHeader("X-Time-Zone","Europe/Rome")
                .setHeader("Content-Type","application/json")
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        JsonObject jsonObject1 = new JsonParser().parse(response.body()).getAsJsonObject();
         String errors = String.valueOf(jsonObject1.get("errors"));
            return errors;
    }

    public TransactionPayload getTransactions() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Auth-Schema", AUTH_SCHEMA);
        httpHeaders.set("Api-Key",API_KEY);
        httpHeaders.set("X-Time-Zone","Europe/Rome");
        httpHeaders.set("Content-Type","application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        TransactionResponse transactionResponse = new TransactionResponse();
        ResponseEntity<TransactionResponse> responsee = restTemplate.exchange(
                "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/"+ACCOUNT_ID+"/transactions?fromAccountingDate=2019-01-01&toAccountingDate=2019-11-01", HttpMethod.GET, requestEntity, TransactionResponse.class);
        return responsee.getBody().getTransactionPayload();

    }


}
