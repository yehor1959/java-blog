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

    @Test
    public void createPost_shouldCreatePost_whenValidData() {
        // given
        // when
        // then
    }

    @Test
    public void createPost_shouldNotCreatePost_whenTitleIsBlank() {
        // given
        // when
        // then
    }

    @Test
    public void updatePost_shouldUpdatePost_whenPostExists() {
        // given
        // when
        // then
    }

    @Test
    public void updatePost_shouldNotUpdatePost_whenValidationFails() {
        // given
        // when
        // then
    }

    @Test
    public void deletePost_shouldDeletePost_whenPostExists() {
        // given
        // when
        // then
    }

    @Test
    public void deletePost_shouldThrowException_whenDeletingNonExistingPost() {
        // given
        // when
        // then
    }

    @Test
    public void getPostById_shouldReturnPost_whenPostExists() {
        // given
        // when
        // then
    }

    @Test
    public void getAllPosts_shouldReturnAllPosts_whenPostsExist() {
        // given
        // when
        // then
    }

    @Test
    public void validationErrors_shouldThrowValidationException_whenTitleIsBlank() {
        // given
        // when
        // then
    }

    @Test
    public void notFoundException_shouldThrowPostNotFoundException_whenGettingNonExistingPost() {
        // given
        // when
        // then
    }
}
