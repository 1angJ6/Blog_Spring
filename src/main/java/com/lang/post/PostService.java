package com.lang.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lang on 2018/3/16.
 */

@Service
public class PostService implements IPostService{

    @Autowired
    private IPostDAO postDAO;

    @Override
    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }

    @Override
    public Post getPostById(String post_id) {
        return postDAO.getPostById(post_id);
    }

    @Override
    public boolean addPost(Post post) {
        if (postDAO.isPostExist(post.getTitle())) {
            return false;
        } else {
            postDAO.addPost(post);
            return true;
        }
    }

    @Override
    public void updatePost(Post post) {
        postDAO.updatePost(post);
    }

    @Override
    public void deletePost(String post_id) {
        postDAO.deletePost(post_id);
    }
}
