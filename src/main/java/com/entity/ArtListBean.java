package com.entity;

import java.util.List;

public class ArtListBean {
    private Integer num;
    private Integer code;
    private List<Article> arts;

    public ArtListBean(Integer num, Integer code, List<Article> arts) {
        this.num = num;
        this.code = code;
        this.arts = arts;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Article> getArts() {
        return arts;
    }

    public void setArts(List<Article> arts) {
        this.arts = arts;
    }
}
