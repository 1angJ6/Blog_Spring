package com.lang.post;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by lang on 2018/3/16.
 */

@Transactional
@Repository
public class PostDAO implements IPostDAO{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Post> getAllPosts() {
        String query = "FROM Post AS post ORDER BY post.created DESC";
        return (List<Post>) manager.createQuery(query).getResultList();
//        return null;
    }

    @Override
    public Post getPostById(String post_id) {
        return manager.find(Post.class, post_id);
    }

    @Override
    public void addPost(Post post) {
        manager.persist(post);
    }

    @Override
    public void updatePost(Post post) {
        Post _post = getPostById(post.getId());
        _post.setTitle(post.getTitle());
        _post.setContent(post.getContent());
        manager.flush();
    }

    @Override
    public void deletePost(String post_id) {
        manager.remove(getPostById(post_id));
    }

    @Override
    public boolean isPostExist(String title) {
        String query = "FROM Post as post WHERE post.title = ?1";
        int count = manager.createQuery(query).setParameter(1, title).getResultList().size();
        return count > 0;
    }
}
