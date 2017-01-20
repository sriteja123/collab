package collabarationbackend.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import collabarationbackend.model.Blog;
import oracle.sql.DATE;

@Repository("blogDAO")
@EnableTransactionManagement
@Transactional
public class BlogDAOImpl implements BlogDAO {

	
	@Autowired
	SessionFactory sessionFactory;

	Date date;
	public void addBlog(Blog blog) {
		
		Session session=sessionFactory.getCurrentSession();
		System.out.println("session="+session);
		session.saveOrUpdate(blog);
		System.out.println("data successfully saved");
	}
	
	public List<Blog>viewBlogs() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings({ "unchecked" , "deprecation" })
		List<Blog> list = session.createCriteria(Blog.class).list();
		return list;
	}

	 
	public void updateBlog(Blog blog)  {
		
		System.out.println("am in update blog");
		 Session session=sessionFactory.getCurrentSession();
		 date=new Date();
		 String data=date.toString();
		 blog.setDate(data);
		 session.update(blog);
		 
		 }


	 public void deleteBlog(int blog_id) {
		Session session=sessionFactory.getCurrentSession();
		Blog blog=(Blog)session.get(Blog.class, new Integer(blog_id));
		session.delete(blog);
		
	}

	@Override
	public String getBlogByBlogId(int blog_id) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
		
	}

