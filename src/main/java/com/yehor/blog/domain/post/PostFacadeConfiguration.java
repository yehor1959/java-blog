package com.yehor.blog.domain.post;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostFacadeConfiguration {

    @Bean
    PostFacade postFacade(PostRepository postRepository) {
        return new PostFacade(postRepository);
    }
}
