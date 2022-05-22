package com.example.fabrickproject.services;

import com.example.fabrickproject.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

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
    public String createMoneyTransfer() throws Exception {
        HashMap<String,Object> map = new HashMap<>();
        Creditor creditor = new Creditor();
        Account account = new Account();
        TaxRelief taxRelief = new TaxRelief();
        LegalPersonBeneficiary legalPersonBeneficiary = new LegalPersonBeneficiary();
        NaturalPersonBeneficiary naturalPersonBeneficiary = new NaturalPersonBeneficiary();

        creditor.setName("John Doe");
        account.setAccountCode("IT23A0336844430152923804660");
        creditor.setAccount(account);

        taxRelief.setCondoUpgrade(false);
        taxRelief.setCreditorFiscalCode("56258745832");
        taxRelief.setBeneficiaryType("NATURAL_PERSON");

        naturalPersonBeneficiary.setFiscalCode1("MRLFNC81L04A859L");
        legalPersonBeneficiary.setFiscalCode(null);
        taxRelief.setNaturalPersonBeneficiary(naturalPersonBeneficiary);
        taxRelief.setLegalPersonBeneficiary(legalPersonBeneficiary);





        map.put("creditor",creditor);
        map.put("description","Payment invoice 75/2017");
        map.put("amount",800);
        map.put("currency","EUR");
        map.put("taxRelief",taxRelief);
        map.put("legalPersonBeneficiary",legalPersonBeneficiary);
        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(map);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/"+ACCOUNT_ID+"/payments/money-transfers"))

                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(requestBody)))
                .header("Content-Type", "application/json")
                .setHeader("Auth-Schema", AUTH_SCHEMA)
                .setHeader("Api-Key",API_KEY)
                .setHeader("X-Time-Zone","Europe/Rome")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        String status = Integer.toString(response.statusCode());



        return response.body();
    }

    public String getTransactions() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/"+ACCOUNT_ID+"/transactions?fromAccountingDate=2019-04-01&toAccountingDate=2019-04-01"
                ))
                .setHeader("Auth-Schema", AUTH_SCHEMA)
                .setHeader("Api-Key",API_KEY)
                .setHeader("X-Time-Zone","Europe/Rome")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        String status = Integer.toString(response.statusCode());



        return response.body();
    }


}
