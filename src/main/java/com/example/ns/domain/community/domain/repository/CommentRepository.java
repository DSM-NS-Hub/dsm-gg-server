package com.example.ns.domain.community.domain.repository;

import com.example.ns.domain.community.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT * " +
            "FROM comment " +
            "WHERE community_id = :communityId",
            nativeQuery = true)
    List<Comment> findByCommunityId(@Param("communityId") Long communityId);

    // 특정 닉네임의 모든 댓글 조회
    List<Comment> findByNickname(@Param("nickname") String nickname);
}
