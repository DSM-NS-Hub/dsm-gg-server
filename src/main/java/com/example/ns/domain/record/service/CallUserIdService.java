package com.example.ns.domain.record.service;

import com.example.ns.domain.record.present.dto.response.SummonerResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class CallUserIdService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String serverUrl = "https://kr.api.riotgames.com";
    @Value("${riot.api-key}")
    private String mykey;

    public SummonerResponse callRiotAPISummonerByName(String summonerName){
        RestTemplate restTemplate = new RestTemplate();

        String Url = serverUrl + "/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + mykey;
        log.info(Url);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SummonerResponse> response = restTemplate.getForEntity(Url, SummonerResponse.class);

        return response.getBody();
    }
}