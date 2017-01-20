package collabarationbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import collabarationbackend.dao.JobsDao;
import collabarationbackend.model.Blog;
import collabarationbackend.model.Jobs;
import collabarationbackend.model.Query;
import collabarationbackend.model.usercollab;

@RestController
public class JobsRestcontroller {
	
	@Autowired
	JobsDao jobsdao;
	
	//create jobs
	
			@RequestMapping(value = "/jobs", method = RequestMethod.POST)
			    public ResponseEntity<Void> addjobs(@RequestBody  Jobs jobs,    UriComponentsBuilder ucBuilder) {
			  jobsdao.addjobs(jobs);
			        
			        @SuppressWarnings("unused")
			        HttpHeaders headers = new HttpHeaders();
			        headers.setLocation(ucBuilder.path("/jobs/{jobsid}").buildAndExpand(jobs.getJobid()).toUri());
			        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			    }
			
			//retrieve jobs
			@RequestMapping(value = "/jobs/", method = RequestMethod.GET)
			    public ResponseEntity<List<Jobs>> viewBlogs() {
				
				System.out.println("am in blog rest controller");
			        List<Jobs> users = jobsdao.viewJobs();
			        System.out.println(users.toString());
			        
			        if(users.isEmpty()){
			            return new ResponseEntity<List<Jobs>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
			        }
			        return new ResponseEntity<List<Jobs>>(users, HttpStatus.OK);
			    }
			
//update the jobs
			
			@RequestMapping(value = "/updateJobs",headers="Accept=application/json", method=RequestMethod.PUT)
		    public void updatequery(@RequestBody Jobs jobs) {
		       
				System.out.println("inside update query");
		  
				jobsdao.updatejob(jobs);
		        
		    }
			//delete a jobs
			
			@RequestMapping(value = "/jobs/{jobid}", method = RequestMethod.DELETE)
		    public void deletejob(@PathVariable("jobid")int jobid) {
		       
				System.out.println("i am in blog rest controller");
		  
				jobsdao.deletejob(jobid);
		        
		    }

}
