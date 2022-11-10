package com.example.ns.domain.record.present.dto.request.match;

import com.example.ns.domain.record.present.dto.request.match.perks.PerkStatsDto;
import lombok.Getter;

import java.util.List;

@Getter
public class PerksDto {
    private PerkStatsDto statsPerk;
    private List<PerkStatsDto> styles;
}
