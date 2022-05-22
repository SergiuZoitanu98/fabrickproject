package com.example.fabrickproject.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Utils {
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    public String getBalance() throws Exception {
        // open a connection, the request method is "GET" by default
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/14537780/balance"))
                .setHeader("Auth-Schema", "S2S")
                .setHeader("Api-Key","FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());
            String status = Integer.toString(response.statusCode());
        // print response body
        System.out.println(response.body());


        return response.body();
    }
}
