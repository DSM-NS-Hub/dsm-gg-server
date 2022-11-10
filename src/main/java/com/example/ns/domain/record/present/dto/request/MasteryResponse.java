package com.example.ns.domain.record.present.dto.request;

import lombok.Getter;

@Getter
public class MasteryResponse {
    private Long championPointsUntilNextLevel;
    private Boolean chestGranted;
    private Long championId;
    private Long lastPlayTime;
    private Integer championLevel;
    private String summonerId;
    private Integer championPoints;
    private Long championPointsSinceLastLevel;
    private Integer tokenEarned;
}
