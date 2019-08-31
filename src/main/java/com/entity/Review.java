package com.entity;

public class Review {
    private int id;
    private String body;
    private Review reply;
    private User owner;
    private Article article;

    @Override
    public String toString() {
        return (owner==null?"用户名":owner.getName()) + "：" + body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Review getReply() {
        return reply;
    }

    public void setReply(Review reply) {
        this.reply = reply;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
