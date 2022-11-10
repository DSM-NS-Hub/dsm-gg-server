package com.example.ns.domain.record.present.dto.response;

import com.example.ns.domain.record.present.dto.request.MasteryResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class MasteryListResponse {
    private Long championId;
    private Integer championLevel;
    private Integer championPoints;
}
