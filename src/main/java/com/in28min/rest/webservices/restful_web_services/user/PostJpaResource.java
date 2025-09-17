package com.in28min.rest.webservices.restful_web_services.user;

import com.in28min.rest.webservices.restful_web_services.jpa.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("jpa/posts")
public class PostJpaResource {

    private PostRepository postRepository;

    public PostJpaResource(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping()
    public List<Post> retrieveAllPosts(@RequestParam(required = false) Integer id) {
        List<Post> posts = postRepository.findAll();

        return posts;

    }

}
