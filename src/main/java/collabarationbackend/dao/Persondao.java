package collabarationbackend.dao;


import java.util.List;
import collabarationbackend.model.usercollab;

public interface Persondao {

	public void addUser(usercollab user);
	public void updateUser(usercollab user);
	public void deleteUser(usercollab user);
	public usercollab getUserByUsername(String username);
	public List<usercollab> listUsers();
	
}
