package com.yehor.blog.domain.post;

import com.yehor.blog.domain.post.dto.PostRequestDto;
import com.yehor.blog.domain.post.dto.PostResponseDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PostFacade {

    private final PostRepository postRepository;

    public List<PostResponseDto> findAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostMapper::mapFromPostToPostDto)
                .collect(Collectors.toList());
    }

    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        Post post = PostMapper.mapFromPostDtoToPost(postRequestDto);
        Post saved = postRepository.save(post);
        return PostMapper.mapFromPostToPostDto(saved);
    }

    void initializePosts() {
        if (postRepository.findAll().isEmpty()) {

            postRepository.save(Post.builder()
                    .title("First post")
                    .content("Content of first post")
                    .author("admin")
                    .slug("first-post")
                    .build());

            postRepository.save(Post.builder()
                    .title("Second post")
                    .content("Content of second post")
                    .author("admin")
                    .slug("second-post")
                    .build());

            postRepository.save(Post.builder()
                    .title("Third post")
                    .content("Content of third post")
                    .author("admin")
                    .slug("third-post")
                    .build());

            postRepository.save(Post.builder()
                    .title("Fourth post")
                    .content("Content of fourth post")
                    .author("admin")
                    .slug("fourth-post")
                    .build());
        }
    }
}
