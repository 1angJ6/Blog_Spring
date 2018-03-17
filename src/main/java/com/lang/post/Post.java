package com.lang.post;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lang on 2018/3/16.
 */

@Entity
@Table(name = "posts")
public class Post implements Serializable{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "post_id")
    private String post_id;

    @Column(name = "title")
    private String title;

    @Column(name = "tag")
    private String tag;

    @Column(name = "created")
    private Date created;

    @Column(name = "click")
    private int click;

    @Column(name = "content", columnDefinition = "TEXT")
    private String Content;

    public String getId() {
        return post_id;
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public Date getCreated() {
        return created;
    }

    public int getClick() {
        return click;
    }

    public String getContent() {
        return Content;
    }

    public void setId(String post_id) {
        this.post_id = post_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public void setContent(String content) {
        Content = content;
    }
}
