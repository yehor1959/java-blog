package com.yehor.blog.domain.post;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostFacadeTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostFacade postFacade;

    @Test
    public void should_save_4_posts_when_there_are_no_posts_in_database() {
        // given
        when(postRepository.findAll()).thenReturn(Collections.emptyList());
        when(postRepository.save(any(Post.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ArgumentCaptor<Post> postCaptor = ArgumentCaptor.forClass(Post.class);

        // when
        postFacade.initializePosts();

        // then
        verify(postRepository, times(4)).save(postCaptor.capture());

        List<Post> savedPosts = postCaptor.getAllValues();

        assertThat(savedPosts).hasSize(4);
        assertThat(savedPosts)
                .allSatisfy(post -> {
                    assertThat(post.title()).isNotBlank();
                    assertThat(post.content()).isNotBlank();
                    assertThat(post.author()).isNotBlank();
                    assertThat(post.slug()).isNotBlank();
                });
    }
}
