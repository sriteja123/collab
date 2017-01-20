package collabarationbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="BlogTable",schema="collabo")
public class Blog {

        @Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
        private int bid;
		private String blogTitle;
		private String blogDescription;
		private String cdate;
		private String postedBy;
		private String category;
		
		public void setDate(String data) {
			
			
		}
		public int getBlog_id() {
			return bid;
		}
		public void setBlog_id(int blog_id) {
			this.bid = blog_id;
		}
		public String getBlogTitle() {
			return blogTitle;
		}
		public void setBlogTitle(String blogTitle) {
			this.blogTitle = blogTitle;
		}
		public String getBlogDescription() {
			return blogDescription;
		}
		public void setBlogDescription(String blogDescription) {
			this.blogDescription = blogDescription;
		}
		public String getPostedBy() {
			return postedBy;
		}
		public void setPostedBy(String postedBy) {
			this.postedBy = postedBy;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getDate() {
			return cdate;
		}


		}


