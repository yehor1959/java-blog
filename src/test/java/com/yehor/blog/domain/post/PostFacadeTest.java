package com.yehor.blog.domain.post;

import com.yehor.blog.domain.post.dto.PostRequestDto;
import com.yehor.blog.domain.post.dto.PostResponseDto;
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
    public void createPost_shouldCreatePost_whenDataIsValid() {
        // given
        PostRequestDto postRequestDto = PostRequestDto.builder()
                .title("Test Title")
                .content("Test Content")
                .author("John")
                .slug("test-title")
                .build();

        ArgumentCaptor<Post> postCaptor = ArgumentCaptor.forClass(Post.class);

        when(postRepository.save(any(Post.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // when
        PostResponseDto response = postFacade.createPost(postRequestDto);

        // then
        verify(postRepository).save(postCaptor.capture());

        Post savedPost = postCaptor.getValue();

        assertThat(savedPost.title()).isEqualTo("Test Title");
        assertThat(savedPost.content()).isEqualTo("Test Content");
        assertThat(savedPost.author()).isEqualTo("John");
        assertThat(savedPost.slug()).isNotBlank();

        assertThat(response.title()).isEqualTo("Test Title");
        assertThat(response.content()).isEqualTo("Test Content");
        assertThat(response.author()).isEqualTo("John");
        assertThat(response.slug()).isNotBlank();
    }

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
        Post post1 = new Post(
                "1",
                "Title 1",
                "Content 1",
                "John",
                "title-1"
        );

        Post post2 = new Post(
                "2",
                "Title 2",
                "Content 2",
                "Mike",
                "title-2"
        );

        when(postRepository.findAll())
                .thenReturn(List.of(post1, post2));

        // when
        List<PostResponseDto> result = postFacade.findAllPosts();

        // then
        verify(postRepository, times(1)).findAll();

        assertThat(result).hasSize(2);

        assertThat(result.get(0).id()).isEqualTo("1");
        assertThat(result.get(0).title()).isEqualTo("Title 1");
        assertThat(result.get(0).content()).isEqualTo("Content 1");
        assertThat(result.get(0).author()).isEqualTo("John");
        assertThat(result.get(0).slug()).isEqualTo("title-1");

        assertThat(result.get(1).id()).isEqualTo("2");
        assertThat(result.get(1).title()).isEqualTo("Title 2");
        assertThat(result.get(1).content()).isEqualTo("Content 2");
        assertThat(result.get(1).author()).isEqualTo("Mike");
        assertThat(result.get(1).slug()).isEqualTo("title-2");
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
