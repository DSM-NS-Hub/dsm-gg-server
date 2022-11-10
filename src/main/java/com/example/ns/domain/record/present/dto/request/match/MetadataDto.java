package com.example.ns.domain.record.present.dto.request.match;

import lombok.Getter;

import java.util.List;

@Getter
public class MetadataDto {
    private String dataVersion;
    private String matchId;
    private List<String> participants;
}
