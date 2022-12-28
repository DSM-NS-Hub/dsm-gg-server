package com.example.ns.domain.community.present;

import com.example.ns.domain.community.domain.Community;
import com.example.ns.domain.community.present.dto.CommunityForm;
import com.example.ns.domain.community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping("/board/list")
    public List<Community> index() {
        return communityService.index();
    }

    @GetMapping("/board/{id}")
    public Community show(@PathVariable Long id) {
        return communityService.show(id);
    }

    @PostMapping("/board")
    public ResponseEntity<Community> create(@RequestBody CommunityForm dto) {
        Community created = communityService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.CREATED).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/board/{id}")
    public ResponseEntity<Community> update(@PathVariable Long id, @RequestBody CommunityForm dto) {
        Community updated = communityService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<Community> delete(@PathVariable Long id) {
        Community deleted = communityService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
