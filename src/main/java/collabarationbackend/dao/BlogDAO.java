package collabarationbackend.dao;

import java.util.List;
import collabarationbackend.model.Blog;

public interface BlogDAO {
	
	public void addBlog(Blog blog);
	public List<Blog> viewBlogs();
	public void updateBlog(Blog blog);
	public void deleteBlog(int bid);
	public String getBlogByBlogId(int bid);

}
