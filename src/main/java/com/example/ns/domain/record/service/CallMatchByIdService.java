package com.example.ns.domain.record.service;

import com.example.ns.domain.record.present.dto.response.MatchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CallMatchByIdService {

    private final String serverUrl = "https://asia.api.riotgames.com";

    @Value("${riot.api-key}")
    private String mykey;

    public MatchResponse CallMatchById(String matchId){
        RestTemplate restTemplate = new RestTemplate();

        String Url = serverUrl + "/lol/match/v5/matches/" + matchId + "?api_key=" + mykey;

        HttpEntity<MatchResponse> response = restTemplate.getForEntity(Url, MatchResponse.class);

        return response.getBody();
    }

}
