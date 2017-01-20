package collabarationbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import collabarationbackend.model.JobRegistration;
import collabarationbackend.model.Jobs;

@Transactional
@Repository
public class JobsDaoImpl implements JobsDao{
	
	@Autowired
	SessionFactory SessionFactory;

	
	public void addjobs(Jobs job) {
		Session session=SessionFactory.getCurrentSession();
		session.save(job);
		// TODO Auto-generated method stub
		
	}

	
	public List<Jobs> viewJobs() {
		Session session=SessionFactory.getCurrentSession();
		return session.createCriteria(Jobs.class).list();
		
		
		// TODO Auto-generated method stub
		
	}

	
	public void deletejob(int id) {
		Session session=SessionFactory.getCurrentSession();
		Jobs job=(Jobs)session.get(Jobs.class ,  new  Integer(id));
		session.delete(job);
		
		// TODO Auto-generated method stub
		
	}

	
	public void updatejob(Jobs job) {
		Session session=SessionFactory.getCurrentSession();
		session.update(job);
		
		
		// TODO Auto-generated method stub
		
	}

	
	public Jobs viewjob(int id) {
		Session session=SessionFactory.getCurrentSession();
		Jobs job=(Jobs) session.get(Jobs.class, new Integer (id));
		
		// TODO Auto-generated method stub
		return null;
	}

	public void registerjob(JobRegistration jobRegistration) {
		Session session=SessionFactory.getCurrentSession();
		session.save(jobRegistration);
		
		// TODO Auto-generated method stub
		
	}

}
