import com.DAO.ArticleMapper;
import com.entity.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class TestAricleDAO {
    private ArticleMapper mapper;
    @Before
    public void init() throws IOException {
        String resource = "com/config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);//Resources获取资源输入流inputStream
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//构造工厂
        SqlSession session = sqlSessionFactory.openSession();//工厂制作sqlSession
        mapper=session.getMapper(ArticleMapper.class);
    }

    @Test
    public void testSearch(){
        Article a=new Article();
        a.setClas("python");
        a.setTitle("崔庆才");
        //a.setTime(LocalDate.of(2019,3,23));
        List<Article> articles=mapper.searchArticles(a,new RowBounds(5,5));
        for(var s : articles){
            System.out.println(s);
        }
    }
}