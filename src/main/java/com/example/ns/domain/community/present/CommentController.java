package com.example.ns.domain.community.present;

import com.example.ns.domain.community.present.dto.CommentDto;
import com.example.ns.domain.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/board/{communityId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long communityId) {
        List<CommentDto> dtos = commentService.comments(communityId);

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping("/board/{communityId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long communityId, @RequestBody CommentDto dto) {
        CommentDto createdDto = commentService.create(communityId, dto);

        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    @PatchMapping("/board/comments/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Long id, @RequestBody CommentDto dto) {
        CommentDto updatedDto = commentService.update(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    @DeleteMapping("/board/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) {
        CommentDto updatedDto = commentService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }
}
