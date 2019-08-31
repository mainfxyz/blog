package com.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Article {
    private Integer id;
    private String title;
    private String body;
    private String author;
    private String clas;
    private LocalDate time;
    private int cnt;
    private String summary;
    private String tag;
    private List<Review> reviews;
    private int revCnt;//偶合

    public Article() {
    }

    public Article(String title, String body, String clas) {
        this.title = title;
        this.body = body;
        this.author = "老万";
        this.clas = clas;
        this.time = LocalDate.now();
    }

    @Override
    public String toString() {
        return  String.format("%4d",id)+
                "、 标题：" + title +"\n\t"+
                " 摘要：" + summary +"\n\t"+
                " 作者：" + author +
                " 类别：" + clas +
                " 创作时间：" + time +
                " 浏览次数：" + cnt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getRevCnt() {
        return revCnt;
    }

    public void setRevCnt(int revCnt) {
        this.revCnt = revCnt;
    }

}
