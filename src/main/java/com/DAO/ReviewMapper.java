package com.DAO;

import com.entity.Review;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewMapper {
    List<Review> showReviews(int articleId);
    @Insert("insert into review(article_id,user_id,body,reply_id) " +
            "values(#{article_id},#{user_id},#{body},#{reply_id});")
    int addReview(@Param("article_id")int articleId,@Param("user_id")int userId,
                  @Param("body")String body,@Param("reply_id")int reply_id);
}
