package com.example.ns.domain.record.service;

import com.example.ns.domain.record.present.dto.response.MatchResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FinalSearchService {
    private final CallUserIdService callUserIdService;
    private final FindMatchService findMatchService;
    private final CallMatchByIdService callMatchByIdService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<MatchResponse> searchRecord(String username) throws Exception {
        String puuid = callUserIdService.callRiotAPISummonerByName(username).getPuuid();
        String[] matchesId = findMatchService.CallMatchesByPuuid(puuid);
        List<MatchResponse> result = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            MatchResponse match = callMatchByIdService.CallMatchById(matchesId[i]);
            String matchJson = objectMapper.writeValueAsString(match);
            MatchResponse jsonToObject = objectMapper.readValue(matchJson, MatchResponse.class);
            List<String> users = userList(jsonToObject.getMetadata().getParticipants());
            for(int j=0; j<10; j++){
                jsonToObject.getMetadata().getParticipants().set(j, users.get(j));
            }
            result.add(jsonToObject);
        }
        return result;
    }

    public List<String> userList(List<String> participants) {
        for(int i=0; i<10; i++){
            String UserName = callUserIdService.callUserInfoByPuuid(participants.get(i)).getName();
            participants.set(i, UserName);
        }
        return participants;
    }
}

