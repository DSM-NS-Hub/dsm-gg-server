package com.example.ns.domain.record.service;

import com.example.ns.domain.record.present.dto.request.MasteryResponse;
import com.example.ns.domain.record.present.dto.response.MasteryListResponse;
import com.example.ns.global.error.exception.ErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CallMasteryService {

    private final String serverUrl = "https://kr.api.riotgames.com";

    @Value("${riot.api-key}")
    private String mykey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<MasteryResponse> callMasteryBySummonerId(String summonerId) throws Exception {
        RestTemplate restTemplate = new RestTemplate();


        String Url = serverUrl + "/lol/champion-mastery/v4/champion-masteries/by-summoner/" + summonerId + "/top" + "?api_key=" + mykey;
        List<MasteryResponse> response = restTemplate.getForObject(Url, List.class);

        String masteryJson = objectMapper.writeValueAsString(response);
        List<MasteryResponse> masteryObject = objectMapper.readValue(masteryJson, List.class);

        return masteryObject;
    }
}
