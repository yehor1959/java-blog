package com.yehor.blog.domain.post;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    public void deletePostById_shouldDeletePostById_whenPostExists() {
        // given
        String postId = "1";

        when(postRepository.existsById(postId))
                .thenReturn(true);

        // when
        postService.deletePostById(postId);

        // then
        verify(postRepository).existsById(postId);
        verify(postRepository).deleteById(postId);
    }
}
