package com.example.ns.domain.record.present.dto.request.match.perks;

import lombok.Getter;

import java.util.List;

@Getter
public class PerkStyleDto {
    private String description;
    private List<PerkStyleSelectionDto> selection;
    private int style;
}
