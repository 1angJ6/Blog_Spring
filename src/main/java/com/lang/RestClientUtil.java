package com.lang;

import com.lang.admin.Admin;
import com.lang.post.Post;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;

/**
 * Created by lang on 2018/3/17.
 */
public class RestClientUtil {

    public void addPostDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/post";
        Post post = new Post();
        post.setTitle("Spring boot rest");
        post.setClick(0);
        post.setCreated(new Date());
        post.setTag("test");
        post.setContent("Spring boot rest test content...........");
        HttpEntity<Post> entity = new HttpEntity<>(post, headers);
        URI uri = restTemplate.postForLocation(url, entity);
        System.out.println(uri.getPath());
    }

    public void auth() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/auth/login";
        Admin admin = new Admin();
        HttpEntity<Post> entity = new HttpEntity<>(admin, headers);
        URI uri = restTemplate.postForLocation(url, entity);
        System.out.println(uri.getPath());
    }

    public static void main(String[] args) {
        RestClientUtil util = new RestClientUtil();
//        util.addPostDemo();
        util.auth();
    }

}
