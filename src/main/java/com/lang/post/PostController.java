package com.lang.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by lang on 2018/3/16.
 */

@Controller
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping("post/{post_id}")
    public ResponseEntity<Post> getPostById(@PathVariable("post_id") String post_id) {
        Post post = postService.getPostById(post_id);
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @GetMapping("posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }

    @PostMapping("post")
    public ResponseEntity<Void> addPost(@RequestBody Post post, UriComponentsBuilder builder) {
        boolean isSuccessful = postService.addPost(post);
        if (!isSuccessful) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/post/{id}").buildAndExpand(post.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
