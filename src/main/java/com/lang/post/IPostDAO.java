package com.lang.post;

import java.util.List;

/**
 * Created by lang on 2018/3/16.
 */
public interface IPostDAO {

    List<Post> getAllPosts();
    Post getPostById(String post_id);
    void addPost(Post post);
    void updatePost(Post post);
    void deletePost(String post_id);
    boolean isPostExist(String title);

}
