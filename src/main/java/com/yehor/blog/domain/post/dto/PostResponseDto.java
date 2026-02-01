package com.yehor.blog.domain.post.dto;

import lombok.Builder;

@Builder
public record PostResponseDto(
        String id,
        String title,
        String content,
        String author,
        String slug
) {
}
