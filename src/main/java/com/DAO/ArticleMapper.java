package com.DAO;

import com.entity.Article;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface ArticleMapper {

    @Select("select * from article where id=#{id}")
    Article showArticle(int id);

    List<Article> searchArticles(Article article, RowBounds rowBounds);

    ArrayList<Article> searchArticles(Article article);

    int addArticle(Article article);
}
