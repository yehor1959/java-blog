package com.yehor.blog.domain.post;

import com.yehor.blog.domain.post.dto.PostRequestDto;
import com.yehor.blog.domain.post.dto.PostResponseDto;

public class PostMapper {

    public static PostResponseDto mapFromPostToPostDto(Post post) {
        return PostResponseDto.builder()
                .id(post.id())
                .title(post.title())
                .content(post.content())
                .author(post.author())
                .slug(post.slug())
                .build();
    }

    public static Post mapFromPostDtoToPost(PostRequestDto post) {
        return Post.builder()
                .title(post.title())
                .content(post.content())
                .author(post.author())
                .slug(post.slug())
                .build();
    }
}
