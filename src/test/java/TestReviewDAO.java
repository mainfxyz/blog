import com.DAO.ReviewMapper;
import com.entity.Review;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestReviewDAO {
    private ReviewMapper mapper;
    @Before
    public void init() throws IOException {
        String resource = "com/config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);//Resources获取资源输入流inputStream
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//构造工厂
        SqlSession session = sqlSessionFactory.openSession();//工厂制作sqlSession
        mapper=session.getMapper(ReviewMapper.class);
    }

    @Test
    public void testSelect(){
        var s=mapper.showReviews(2);
        for(var ss : s)
            System.out.println(ss);
    }
    @Test
    public void testAdd(){
        mapper.addReview(2,2,"good",1);
    }
}
