package com.example.ns.domain.community.service;

import com.example.ns.domain.community.domain.Comment;
import com.example.ns.domain.community.domain.Community;
import com.example.ns.domain.community.domain.repository.CommentRepository;
import com.example.ns.domain.community.domain.repository.CommunityRepository;
import com.example.ns.domain.community.present.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommunityRepository communityRepository;

    public List<CommentDto> comments(Long communityId) {
        return commentRepository.findByCommunityId(communityId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long communityId, CommentDto dto) {
        Community community = communityRepository.findById(communityId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다."));

        Comment comment = Comment.createComment(dto, community);

        Comment created = commentRepository.save(comment);

        return CommentDto.createCommentDto(created);
    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다."));

        target.patch(dto);

        Comment updated = commentRepository.save(target);

        return CommentDto.createCommentDto(updated);
    }

    @Transactional
    public CommentDto delete(Long id) {
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! 대상이 없습니다."));

        commentRepository.delete(target);

        return CommentDto.createCommentDto(target);
    }
}
