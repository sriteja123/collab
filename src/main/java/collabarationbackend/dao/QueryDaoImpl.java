package collabarationbackend.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import collabarationbackend.model.Blog;
import collabarationbackend.model.Query;

@Repository("QueryDao")
@EnableTransactionManagement
@Transactional
public class QueryDaoImpl implements QueryDao {
	
	@Autowired
	SessionFactory  SessionFactory;
	
	
	public void addquery(Query query) {
		
		Session session=SessionFactory.getCurrentSession();
		System.out.println("session"+session);
		session.saveOrUpdate(query);
		System.out.println("data successfully saved");
		
		// TODO Auto-generated method stub
		}

	
	public List<Query> viewQuestions() {
		Session session = SessionFactory.getCurrentSession();
		@SuppressWarnings({ "unchecked" , "deprecation" })
		List<Query> list = session.createCriteria(Blog.class).list();
		return list;
	}

	
	public void updatequery(Query query) {
		
		System.out.println("am in update blog");
		 Session session=SessionFactory.getCurrentSession();
		 session.update(query);
		// TODO Auto-generated method stub
		
	}

	
	public void deletequery(int qid) {
		Session session=SessionFactory.getCurrentSession();
		 Query query=(Query)session.get(Query.class, new Integer(qid));
		session.delete(query);
		
		// TODO Auto-generated method stub
	}

	
	public Query getquery(int qid) {
		// TODO Auto-generated method stub
		return null;
	}

}
