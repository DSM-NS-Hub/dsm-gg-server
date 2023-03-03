package com.example.ns.domain.record.service;

import com.example.ns.domain.record.present.dto.response.RankResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRankService {

    private final String serverUrl = "https://kr.api.riotgames.com";

    @Value("${riot.api-key}")
    private String mykey;

    public List<RankResponse> CallUserSoloRank(String summonerName){
        RestTemplate restTemplate = new RestTemplate();

        String Url = serverUrl + "/lol/league/v4/entries/by-summoner/" + summonerName + "?api_key=" + mykey;

        List<RankResponse> response = restTemplate.getForEntity(Url, List.class).getBody();

        return response;
    }
}
