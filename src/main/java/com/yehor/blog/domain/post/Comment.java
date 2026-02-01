package com.yehor.blog.domain.post;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Builder
record Comment(
        @Field("id")
        String id,

        @Field("author")
        String author,

        @Field("content")
        String content,

        @Field("created_at")
        Instant createdAt
) {
}
