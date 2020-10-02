import com.alibaba.fastjson.JSON;
import com.qst.controller.UserController;
import com.qst.enums.UserStatus;
import com.qst.pojo.User;
import com.qst.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: XiPeng
 * @Description:
 * @Date: Create in 20:03 2020/9/29
 * @Modified by:
 */
public class UserTest {
    @Test
    public void registerTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringContext.xml");
        UserService service = context.getBean(UserService.class);
        User user = new User();
        user.setUsername("1234");
        user.setPassword("123");
        user.setPhone("121212");
        user.setRealname("张三");
        int register = service.register(user);
        if (register==1){
            System.out.println(JSON.toJSONString(UserStatus.REGISTER_SUCCESS));
        }
        else {
            System.out.println(JSON.toJSONString(UserStatus.REGISTER_FAIL));
        }
    }

    @Test
    public void LoginTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringContext.xml");
        UserService service = context.getBean(UserService.class);
        User user = new User();
        user.setUsername("123");
        user.setPassword("123");
        user.setPhone("121212");
        user.setRealname("张三");
        User login = service.login(user);
        if (login!=null){
            System.out.println(JSON.toJSONString(login));
        }
        else {
            System.out.println(JSON.toJSONString(UserStatus.LOGIN_FAIL));
        }
    }
}