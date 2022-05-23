package com.example.fabrickproject.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.http.auth.AUTH;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.EOFException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Component
public class MainService {
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    private final String ACCOUNT_ID ="14537780";
    private final String API_KEY = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
    private final String AUTH_SCHEMA ="S2S";
    public String getBalance() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/"+ ACCOUNT_ID +"/balance"))
                .setHeader("Auth-Schema", AUTH_SCHEMA)
                .setHeader("Api-Key",API_KEY)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String status = Integer.toString(response.statusCode());
        return response.body();
    }
    public String createMoneyTransfer() throws IOException, InterruptedException {
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
        System.out.println(response.statusCode());
        String status = Integer.toString(response.statusCode());
        return response.body();
    }

    public String getTransactions() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/"+ACCOUNT_ID+"/transactions?fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01"
                ))
                .setHeader("Auth-Schema", AUTH_SCHEMA)
                .setHeader("Api-Key",API_KEY)
                .setHeader("X-Time-Zone","Europe/Rome")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }


}
