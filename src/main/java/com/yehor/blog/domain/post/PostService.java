package com.yehor.blog.domain.post;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class PostService {
    PostRepository postRepository;

    public void deletePostById(String id) {
        if (!postRepository.existsById(id)) {
            throw new RuntimeException("Post not found with id: " + id);
        }
        postRepository.deleteById(id);
    }
}
