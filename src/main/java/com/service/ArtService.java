package com.service;

import com.DAO.ArticleMapper;
import com.entity.ArtListBean;
import com.entity.Article;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtService implements ArtSerInt{
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article showArt(int id) {
        return articleMapper.showArticle(id);
    }

    @Override
    public ArtListBean showArtList(Article article, Integer page) {
        ArrayList al=articleMapper.searchArticles(article);
        int num=al.size();

        if(page==null)  page=0;
        if(page>num) page=num;
        if(page<1) page=1;
        page = (page-1) * 10;

        ArrayList<Article> pageAl=new ArrayList<>(10);
        for (int i = page,cnt=0; i < num && cnt<10; i++,cnt++) {
            pageAl.add((Article) al.get(i));
        }
        if(num!=0) num=num/10+1;
        return  new ArtListBean(num,200,pageAl);
    }
}
