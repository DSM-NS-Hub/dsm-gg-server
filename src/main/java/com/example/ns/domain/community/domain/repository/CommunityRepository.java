package com.example.ns.domain.community.domain.repository;

import com.example.ns.domain.community.domain.Community;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CommunityRepository extends JpaRepository<Community, Long> {
    @Override
    ArrayList<Community> findAll();
}
