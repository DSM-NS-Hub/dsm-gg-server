package com.example.ns.domain.record.present.dto.response;

import com.example.ns.domain.record.present.dto.request.match.InfoDto;
import com.example.ns.domain.record.present.dto.request.match.MetadataDto;
import lombok.Getter;

@Getter
public class MatchResponse {
    private MetadataDto metadata;
    private InfoDto info;
}
