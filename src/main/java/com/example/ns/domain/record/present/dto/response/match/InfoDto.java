package com.example.ns.domain.record.present.dto.response.match;

import lombok.Getter;

import java.util.List;

@Getter
public class InfoDto {
    private Long gameCreation;
    private Long gameDuration;
    private Long gameEndTimeStamp;
    private Long gameId;
    private String gameMode;
    private String gameName;
    private Long gameStartTimeStamp;
    private String gameType;
    private String gameVersion;
    private int mapId;
    private List<ParticipantDto> participants;
    private String platformId;
    private int queueId;
    private List<TeamDto> teams;
    private String tournamentCode;
}
