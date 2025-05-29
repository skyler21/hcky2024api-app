package com.hockey.core;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.hockey.core.model.Game;
import java.util.List;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpNHLClient {
    
    public List<Game> findAll(String gameDate) throws IOException, InterruptedException {

       // curl "http://localhost:8085/db/get/findGames?gameSeason=20242025&gameType=Regular&gameTeam=NONE&gameDate=2024-12-18"
       final String BASE_URL = "http://localhost:8085/db/get/findGames?gameSeason=20242025&gameType=Regular&gameTeam=NONE&gameDate=" + gameDate;
       final HttpClient client;
       final ObjectMapper objectMapper;

       client = HttpClient.newHttpClient();
       objectMapper = new ObjectMapper();

       HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL)).GET().build();

       HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

       return objectMapper.readValue(response.body(), new TypeReference<>() {});  

    }


}
