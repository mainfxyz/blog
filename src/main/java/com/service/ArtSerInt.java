package com.service;

import com.entity.ArtListBean;
import com.entity.Article;


public interface ArtSerInt {

    Article showArt(int id);

    ArtListBean showArtList(Article article, Integer page);
}
