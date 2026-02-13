package com.yehor.blog.infrastructure.post.controller;

import com.yehor.blog.domain.post.PostFacade;
import com.yehor.blog.domain.post.PostRepository;
import com.yehor.blog.domain.post.dto.PostRequestDto;
import com.yehor.blog.domain.post.dto.PostResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@Log4j2
@AllArgsConstructor
public class PostRestController {

    private final PostFacade postFacade;

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody @Valid PostRequestDto postRequestDto) {
        PostResponseDto postResponseDto = postFacade.createPost(postRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(postResponseDto);
    }
}
