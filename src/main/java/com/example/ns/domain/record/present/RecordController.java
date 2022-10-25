package com.example.ns.domain.record.present;

import com.example.ns.domain.record.present.dto.response.SummonerResponse;
import com.example.ns.domain.record.service.CallUserIdService;
import com.example.ns.domain.record.service.FindMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class RecordController {

    private final CallUserIdService callUserIdService;

    private final FindMatchService findMatchService;

    @PostMapping("/username")
    public SummonerResponse searchUser(@RequestParam String summonerName){
        summonerName = summonerName.replaceAll(" ","%20");
        return callUserIdService.callRiotAPISummonerByName(summonerName);
    }

    @PostMapping("/matches")
    public String[] callMatches(@RequestParam String summonerName){
        summonerName = summonerName.replaceAll(" ","%20");
        return findMatchService.CallMatchesByPuuid(callUserIdService.callRiotAPISummonerByName(summonerName).getPuuid());
    }
}
