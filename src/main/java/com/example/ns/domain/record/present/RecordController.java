package com.example.ns.domain.record.present;

import com.example.ns.domain.record.present.dto.request.MasteryRequest;
import com.example.ns.domain.record.present.dto.response.MatchResponse;
import com.example.ns.domain.record.present.dto.response.RankResponse;
import com.example.ns.domain.record.present.dto.response.SummonerResponse;
import com.example.ns.domain.record.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class RecordController {

    private final CallUserIdService callUserIdService;

    private final FindMatchService findMatchService;
    private final CallMatchByIdService callMatchByIdService;
    private final FinalSearchService finalSearchService;
    private final CallMasteryService callMasteryService;

    private final UserRankService userRankService;

    @PostMapping("/username")
    public SummonerResponse searchUser(@RequestParam String summonerName){
        summonerName = summonerName.replaceAll(" ","%20");
        return callUserIdService.callRiotAPISummonerByName(summonerName);
    }

    @PostMapping("/matches")
    public String[] callMatches(@PathVariable String summonerName){
        summonerName = summonerName.replaceAll(" ","%20");
        return findMatchService.CallMatchesByPuuid(callUserIdService.callRiotAPISummonerByName(summonerName).getPuuid());
    }

    @PostMapping("/{matchId}")
    public MatchResponse callMatchById(@PathVariable String matchId){
        return callMatchByIdService.CallMatchById(matchId);
    }

    @PostMapping("/user")
    public List<MatchResponse> search(@RequestParam String summonerName) throws Exception {
        summonerName = summonerName.replaceAll(" ","%20");
        return finalSearchService.searchRecord(summonerName);

    }

    @PostMapping("/mastery/{summonerName}")
    public List<MasteryRequest> userMastery(@PathVariable String summonerName) throws Exception {
        log.info(summonerName);
        String summonerId = callUserIdService.callRiotAPISummonerByName(summonerName).getId();
        return callMasteryService.callMasteryBySummonerId(summonerId);

    }

    @PostMapping("/rank/{summonerName}")
    public List<RankResponse> userRank(@PathVariable String summonerName) throws Exception {
        String summonerId = callUserIdService.callRiotAPISummonerByName(summonerName).getId();
        return userRankService.CallUserSoloRank(summonerId);
    }
}
