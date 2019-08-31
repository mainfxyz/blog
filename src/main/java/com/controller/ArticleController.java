package com.controller;

import com.DAO.ArticleMapper;
import com.entity.ArtListBean;
import com.entity.Article;
import com.service.ArtSerInt;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/art")
@EnableAutoConfiguration
public class ArticleController {
    @Autowired
    private ArtSerInt artSerInt;

    @RequestMapping(value = "/list")
    @ResponseBody
    public ArtListBean showArtList(@ModelAttribute Article article,
                                   @Param("page")Integer page,
                                   @Param("searchType")String searchType,
                                   @Param("search")String search){
        if(article==null){
            article=new Article();
        }
        if(searchType==null){
            searchType="";
        }
        switch (searchType){
            case "body":    article.setBody(search);break;
            case "title":   article.setTitle(search);break;
            case "tag":     article.setTag(search);break;
        }

        return artSerInt.showArtList(article,page);
    }

    @RequestMapping(value = "/show",method= RequestMethod.GET)
    @ResponseBody
    public Article showArt(@Param("id")Integer id){
        return artSerInt.showArt(id);
    }
}
