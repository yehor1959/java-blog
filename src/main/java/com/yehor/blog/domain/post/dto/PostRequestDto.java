package com.yehor.blog.domain.post.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record PostRequestDto(
        @NotNull(message = "{title.not.null}")
        @NotEmpty(message = "{title.not.empty}")
        String title,

        @NotNull(message = "{content.not.null}")
        @NotEmpty(message = "{content.not.empty}")
        String content,

        @NotNull(message = "{author.not.null}")
        @NotEmpty(message = "{author.not.empty}")
        String author,

        @NotNull(message = "{slug.not.null}")
        @NotEmpty(message = "{slug.not.empty}")
        String slug
) {
}
