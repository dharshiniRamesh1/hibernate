package com.projects12.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Project {
	@Id
	@Column( name = "PR_ID" , unique=true,nullable = false)
	private int prid;
	private String name;
	private String owner;
	  
	

	
	
	@ManyToMany(mappedBy = "empAssisgnmentList")
	private List<Employee> employees;
	public int getPrid() {
		return prid;
	}
	public void setPrid(int prid) {
		this.prid = prid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Project [prid=" + prid + ", name=" + name + ", owner=" + owner + ", employees=" + employees + "]";
	}
	
	
	
	
}

