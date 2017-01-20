package collabarationbackend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import collabarationbackend.dao.BlogDAO;
import collabarationbackend.model.Blog;
import collabarationbackend.model.usercollab;

@RestController
public class Blogcontroller {

	@Autowired
	BlogDAO BlogDAO;
	
	//retrieve all users
		@RequestMapping(value = "/blog/", method = RequestMethod.GET)
		    public ResponseEntity<List<Blog>> viewBlogs() {
			
			System.out.println("am in blog rest controller");
		        List<Blog> users = BlogDAO.viewBlogs();
		        System.out.println(users.toString());
		        
		        if(users.isEmpty()){
		            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		        }
		        return new ResponseEntity<List<Blog>>(users, HttpStatus.OK);
		    }
		
		 //create blog
		
		@RequestMapping(value = "/blog", method = RequestMethod.POST)
		    public ResponseEntity<Void> addBlogData(@RequestBody  Blog blog,    UriComponentsBuilder ucBuilder) {
		        System.out.println("user name " +blog.getBlogTitle());
		  
		       BlogDAO.addBlog(blog);
		        
		        @SuppressWarnings("unused")
		        HttpHeaders headers = new HttpHeaders();
		        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(blog.getBlog_id()).toUri());
		        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		    }
		
		//delete a blog
		
		@RequestMapping(value = "/blog/{bid}", method = RequestMethod.DELETE)
	    public void deleteBlog(@PathVariable("bid")int bid) {
	       
			System.out.println("i am in blog rest controller");
	  
			BlogDAO.deleteBlog(bid);
	        
	    }
		
		//update the blog
				@RequestMapping(value = "/updateBlog", method=RequestMethod.PUT)
			    public void updateBlog(@RequestBody Blog blog) {
			       
					System.out.println("inside update blog");
			  
					BlogDAO.updateBlog(blog);
			        
			    }
				
		
		
		
		
		
		
		
}

