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

import collabarationbackend.dao.Persondao;
import collabarationbackend.model.usercollab;

@RestController
public class Restcontroller {
	
	@Autowired
	Persondao userDAO;
	
	
	//retrieve all users
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	    public ResponseEntity<List<usercollab>> listAllUsers() {
	        List<usercollab> users = userDAO.listUsers();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<usercollab>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<usercollab>>(users, HttpStatus.OK);
	    }
	
	
	
	 //create user
	 @RequestMapping(value = "/user/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody usercollab user,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + user.getUsername());
	  
	       
	  
	        userDAO.addUser(user);
	  
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	//------------------- Update a User --------------------------------------------------------
     
	    @RequestMapping(value = "/user/{username}", method = RequestMethod.PUT)
	    public ResponseEntity<usercollab> updateUser(@PathVariable("username") String username, @RequestBody usercollab user) {
	        System.out.println("Updating User " + userDAO.getUserByUsername( username));
	         
	       
			usercollab currentUser =userDAO.getUserByUsername( username);
	         
	       
	 
	        currentUser.setUsername(user.getUsername());
	        currentUser.setPassword(user.getPassword());
	        currentUser.setMobile(user.getMobile());
	        currentUser.setCity(user.getCity());
	        currentUser.setRole(user.getRole());
	         
	        userDAO.updateUser(currentUser);
	        return new ResponseEntity<usercollab>(currentUser, HttpStatus.OK);
	    }
	    
	  //------------------- Delete a User --------------------------------------------------------
	      
	    @RequestMapping(value = "/user/{username}", method = RequestMethod.DELETE)
	    public void deleteUser(@PathVariable("username") String username) {
	       
	  
	        userDAO.deleteUser(userDAO.getUserByUsername( username));
	        
	    }
	 
	  
	    }
