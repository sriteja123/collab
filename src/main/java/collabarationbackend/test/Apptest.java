package collabarationbackend.test;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import collabarationbackend.config.ApplicationContextConfig;
import collabarationbackend.dao.Persondao;
import collabarationbackend.model.usercollab;;

/**
 * Hello world!
 *
 */
public class Apptest 
{
    public static void main( String[] args )
    {
       AbstractApplicationContext context=new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
       
       Persondao userDAO=(Persondao)context.getBean("Person");
       
       // create a new User
       
       usercollab user=new usercollab();
       
       
       user.setUsername("will");
       user.setPassword("password@123");
       user.setCity("NY");
       user.setMobile("1234567891");
       user.setRole("User");
       
       userDAO.addUser(user);
    }
}
