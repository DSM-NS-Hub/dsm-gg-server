package com.example.ns.domain.community.service;

import com.example.ns.domain.community.domain.Community;
import com.example.ns.domain.community.domain.repository.CommunityRepository;
import com.example.ns.domain.community.present.dto.CommunityForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    public List<Community> index() {
        return communityRepository.findAll();
    }

    public Community show(Long id) {
        return communityRepository.findById(id).orElse(null);
    }

    public Community create(CommunityForm dto) {
        Community community = dto.toEntity();
        if (community.getId() != null) {
            return null;
        }
        return communityRepository.save(community);
    }

    public Community update(Long id, CommunityForm dto) {
        Community article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        Community target = communityRepository.findById(id).orElse(null);

        if (target == null || id != article.getId()) {
            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
            return null;
        }

        target.patch(article);
        Community updated = communityRepository.save(target);
        return updated;
    }

    public Community delete(Long id) {
        Community target = communityRepository.findById(id).orElse(null);

        if(target == null) {
            return null;
        }

        communityRepository.delete(target);
        return target;
    }
}
