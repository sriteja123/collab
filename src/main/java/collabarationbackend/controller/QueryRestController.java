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

import collabarationbackend.dao.QueryDao;
import collabarationbackend.model.Blog;
import collabarationbackend.model.Query;

@RestController
public class QueryRestController {
	
	@Autowired
	QueryDao querydao;
	
	@RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResponseEntity<Void> addquery(@RequestBody  Query query,    UriComponentsBuilder ucBuilder) {
        System.out.println("user name " +query.getQuestTitle());
  
        querydao.addquery(query);
        
        @SuppressWarnings("unused")
        HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(blog.getBlog_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	//retrieve all queries
			@RequestMapping(value = "/query/", method = RequestMethod.GET)
			    public ResponseEntity<List<Query>> viewQuestions() {
				
				System.out.println("am in query rest controller");
			        List<Query> users = querydao.viewQuestions();
			        System.out.println(users.toString());
			        
			        if(users.isEmpty()){
			            return new ResponseEntity<List<Query>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
			        }
			        return new ResponseEntity<List<Query>>(users, HttpStatus.OK);
			    } 
			
			//delete a query
			
			@RequestMapping(value = "/myquery/{qid}", method = RequestMethod.DELETE)
		    public void deletequery(@PathVariable("qid")int qid) {
		       
				System.out.println("i am in query rest controller");
		  
				querydao.deletequery(qid);
		        
		    }
			
			//update the query
			
			@RequestMapping(value = "/update",headers="Accept=application/json", method=RequestMethod.PUT)
		    public void updatequery(@RequestBody Query query) {
		       
				System.out.println("inside update query");
		  
				querydao.updatequery(query);
		        
		    }
			

}
