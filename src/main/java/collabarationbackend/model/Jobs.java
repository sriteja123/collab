package collabarationbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Jobtable", schema="collabo")
public class Jobs {
	@Id
	@GeneratedValue
	private int jobid;
	private String company;
	private String role;
	
	private String skillsrequired;
	private String eligibilitycriteria;
	private String ctc;
	private String DateofInterview;
	private String addressofthecompany;
	private String urlofthecompany;
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSkillsrequired() {
		return skillsrequired;
	}
	public void setSkillsrequired(String skillsrequired) {
		this.skillsrequired = skillsrequired;
	}
	public String getEligibilitycriteria() {
		return eligibilitycriteria;
	}
	public void setEligibilitycriteria(String eligibilitycriteria) {
		this.eligibilitycriteria = eligibilitycriteria;
	}
	public String getCtc() {
		return ctc;
	}
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	public String getDateofInterview() {
		return DateofInterview;
	}
	public void setDateofInterview(String dateofInterview) {
		DateofInterview = dateofInterview;
	}
	public String getAddressofthecompany() {
		return addressofthecompany;
	}
	public void setAddressofthecompany(String addressofthecompany) {
		this.addressofthecompany = addressofthecompany;
	}
	public String getUrlofthecompany() {
		return urlofthecompany;
	}
	public void setUrlofthecompany(String urlofthecompany) {
		this.urlofthecompany = urlofthecompany;
	}
	
}
