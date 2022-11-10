package com.example.ns.domain.record.service;

import com.example.ns.domain.record.present.dto.request.MasteryRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CallMasteryService {

    private final String serverUrl = "https://kr.api.riotgames.com";

    @Value("${riot.api-key}")
    private String mykey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<MasteryRequest> callMasteryBySummonerId(String summonerId) throws Exception {
        RestTemplate restTemplate = new RestTemplate();


        String Url = serverUrl + "/lol/champion-mastery/v4/champion-masteries/by-summoner/" + summonerId + "/top" + "?api_key=" + mykey;
        List<MasteryRequest> response = restTemplate.getForObject(Url, List.class);

        String masteryJson = objectMapper.writeValueAsString(response);
        List<MasteryRequest> masteryObject = objectMapper.readValue(masteryJson, List.class);

        return masteryObject;
    }
}
