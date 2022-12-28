package com.example.ns.domain.community.present.dto;

import com.example.ns.domain.community.domain.Community;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class CommunityForm {
    private Long id;
    private String title;
    private String content;

    public Community toEntity() {
        return new Community(id, title, content);
    }
}
