package com.example.ns.domain.record.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class FindMatchService {

    private final String serverUrl = "https://asia.api.riotgames.com";

    @Value("${riot.api-key}")
    private String mykey;

    public String[] CallMatchesByPuuid(String puuid){
        RestTemplate restTemplate = new RestTemplate();
        int start = 0;
        int count = 10;
        String[] result;

        String Url = serverUrl + "/lol/match/v5/matches/by-puuid/"+ puuid +"/ids" + "?start=" + start + "&count=" + count + "&api_key=" + mykey;

        HttpEntity<String> response = restTemplate.getForEntity(Url, String.class);
        String special_char = "[^0-9a-zA-Z,_]";
        String tmp = response.getBody().replaceAll(special_char, "");
        result = tmp.split(",");

        return result;
    }
}
