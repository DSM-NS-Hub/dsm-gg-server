package com.example.ns.domain.record.present.dto.response;

import lombok.Getter;

@Getter
public class SummonerResponse {
    private String accountId;
    private int profileIconId;
    private long revisionDate;
    private String name;
    private String id;
    private String puuid;
    private long summonerLevel;
}
