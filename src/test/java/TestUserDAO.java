import com.entity.User;
import com.DAO.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUserDAO {
    SqlSession session;
    @Before
    public void sqlSessionInit() throws IOException {
        String resource = "com/config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);//Resources获取资源输入流inputStream
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//构造工厂
        session = sqlSessionFactory.openSession();//工厂制作sqlSession
    }
    @Test
    public void testUserSelect(){
        UserMapper mapper = session.getMapper(UserMapper.class);//获取mapper接口
        List<User> users=mapper.selectAllUser();//接口执行操作
        System.out.println(users);
    }
//    @Test
//    public void testUserInsert(){
//        UserMapper mapper =session.getMapper(UserMapper.class);
//        User user=new User("123@qq.com","newpasswd","name");
//        mapper.addUser(user);
//    }
    @Test
    public void testLogin(){
        UserMapper mapper=session.getMapper(UserMapper.class);
        String passwd=mapper.selectPasswd("123@qq.com");
        System.out.println(passwd);
        passwd=mapper.selectPasswd("12");
        System.out.println(passwd);
    }

    @Test
    public void testDelUser(){
        UserMapper mapper=session.getMapper(UserMapper.class);
        int i=mapper.delUser("newUser");
        System.out.println("删除了"+i+"行");
    }
}
