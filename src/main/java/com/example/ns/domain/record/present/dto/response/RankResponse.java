package com.example.ns.domain.record.present.dto.response;

import com.example.ns.domain.record.present.dto.request.rank.MiniSeriesDto;
import lombok.Getter;

@Getter
public class RankResponse {
    private String leagueId;
    private String summonerId;
    private String summonerName;
    private String queueType;
    private String tier;
    private String rank;
    private Integer leaguePoints;
    private Integer wins;
    private Integer losses;
    private Boolean hotStreak;
    private Boolean veteran;
    private Boolean freshBlood;
    private Boolean inactive;
    private MiniSeriesDto miniSeries;
}
