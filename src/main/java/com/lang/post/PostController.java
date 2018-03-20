package com.lang.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by lang on 2018/3/16.
 */

@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("api")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping("post/{post_id}")
    public ResponseEntity<Post> getPostById(@PathVariable("post_id") String post_id) {
        Post post = postService.getPostById(post_id);
        if (post != null) {
            return new ResponseEntity<Post>(post, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }

    @PostMapping("post")
    public ResponseEntity<String> addPost(@RequestBody Post post, UriComponentsBuilder builder) {
        boolean isSuccessful = postService.addPost(post);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (!isSuccessful) {
            String status = "{\"status\": \"Post is duplicated...\"}";
            return new ResponseEntity<String>(status, headers, HttpStatus.CONFLICT);
        }
        String status = "{\"status\": \"create successfully.\", \"post_id\": \""+ post.getId() +"\"}";
        return new ResponseEntity<String>(status, headers, HttpStatus.CREATED);
    }

    @PutMapping("post")
    public ResponseEntity<Void> updatePost(@RequestBody Post post, UriComponentsBuilder builder) {
        postService.updatePost(post);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/post/{id}").buildAndExpand(post.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @DeleteMapping("post/{post_id}")
    public ResponseEntity<Void> deletePost(@PathVariable("post_id") String post_id) {
        postService.deletePost(post_id);
        // may be redirection... TBD
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
