package com.example.ns.domain.record.present.dto.response.match;

import com.example.ns.domain.record.present.dto.response.match.team.BanDto;
import com.example.ns.domain.record.present.dto.response.match.team.ObjectivesDto;
import lombok.Getter;

import java.util.List;

@Getter
public class TeamDto {
    private List<BanDto> bans;
    private ObjectivesDto objectives;
    private int teamId;
    private boolean win;
}
