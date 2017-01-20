package collabarationbackend.dao;

import java.util.List;

import collabarationbackend.model.Query;

public interface QueryDao {
	
	void addquery(Query query);
	List<Query>viewQuestions();
	void updatequery(Query query);
	void deletequery(int qid);
	Query getquery(int qid);
}
