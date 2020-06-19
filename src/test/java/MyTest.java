import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Books;
import service.BookServiceImpl;

/**
 * @description
 * @author:yujie
 * @Created on 2020/6/18
 */
public class MyTest {




    @Test
    public void test(){
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookServiceImpl bookServiceImpl = context.getBean("BookServiceImpl", BookServiceImpl.class);

        System.out.println(bookServiceImpl.queryAllBooks());

    }
}
