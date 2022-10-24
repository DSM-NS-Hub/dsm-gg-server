package com.example.ns.domain.record.present;

import com.example.ns.domain.record.present.dto.request.SearchUserRequest;
import com.example.ns.domain.record.present.dto.response.SearchUserResponse;
import com.example.ns.domain.record.present.dto.response.SummonerResponse;
import com.example.ns.domain.record.service.CallUserIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class RecordController {

    private final CallUserIdService callUserIdService;

    @PostMapping("/username")
    public SummonerResponse searchUser(@RequestParam String summonerName){
        summonerName = summonerName.replaceAll(" ","%20");
        return callUserIdService.callRiotAPISummonerByName(summonerName);
    }
}
