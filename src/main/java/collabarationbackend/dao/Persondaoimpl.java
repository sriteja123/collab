package collabarationbackend.dao;

import java.util.List;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import collabarationbackend.model.usercollab;

@Repository("Person")
@EnableTransactionManagement
@Transactional
public class Persondaoimpl  implements Persondao {
     
	@Autowired
	SessionFactory sessionFactory;
	
	
	public usercollab getUserByUsername(String username)
	{
		Session session=sessionFactory.getCurrentSession();
		usercollab user=(usercollab)session.createQuery("from usercollab where username='"+username+"'").getSingleResult();
		
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<usercollab> listUsers()
	{
		Session session=sessionFactory.getCurrentSession();
		List<usercollab> users=session.createQuery("from usercollab").getResultList();
		
		return users;
	}

	@Override
	public void addUser(usercollab user) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(usercollab user) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(usercollab user) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(user);
		// TODO Auto-generated method stub
		
	}
	
	

}

