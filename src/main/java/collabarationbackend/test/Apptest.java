package collabarationbackend.test;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import collabarationbackend.config.ApplicationContextConfig;
import collabarationbackend.dao.BlogDAO;
import collabarationbackend.dao.Persondao;
import collabarationbackend.model.Blog;
import collabarationbackend.model.usercollab;


/**
 * Hello world!
 *
 */
public class Apptest 
{
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) 
	{
		  @SuppressWarnings("unused")
		AbstractApplicationContext context=new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
	       
	   /* UserDao userDao = (UserDao) context.getBean("userDAO");
	       
	       UserCollab usercollab= new UserCollab();
	       
	       usercollab.setUsername("Ganesh");
	       usercollab.setPassword("password");
	       usercollab.setMobile("4422112");
	       usercollab.setCity("hyd");
	       usercollab.setRole("User");
	       userDao.addUser(usercollab);
	     */  
	
		  /*BlogDAO blogDAO= (BlogDAO) context.getBean("blogDAO");
		  
		  
		  Blog blog = new Blog();
		  blog.setBlogTitle("mean stack");
		  blog.setBlogDescription("Angular js is pouplar");
	       System.out.println("main ended");
	        */
   }
}
