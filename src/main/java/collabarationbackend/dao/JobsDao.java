package collabarationbackend.dao;

import java.util.List;

import collabarationbackend.model.JobRegistration;
import collabarationbackend.model.Jobs;

public interface JobsDao {
	void addjobs(Jobs job);
	List<Jobs> viewJobs();
	void deletejob(int id);
	void updatejob(Jobs job);
	Jobs viewjob(int id);
	void registerjob(JobRegistration jobRegistration);
}
