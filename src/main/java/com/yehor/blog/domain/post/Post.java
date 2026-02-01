package com.yehor.blog.domain.post;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;

@Builder
@Document("posts")
record Post(
        @Id
        String id,

        @Field("title")
        @Indexed
        String title,

        @Field("content")
        String content,

        @Field("author")
        String author,

        @Field("slug")
        @Indexed(unique = true)
        String slug

//        @Field("created_at")
//        Instant createdAt,

//        @Field("updated_at")
//        Instant updatedAt

//        @Field("comments")
//        List<Comment> comments
) {
}
