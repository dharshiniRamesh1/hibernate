package com.projects12.bean;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="EMP_ID",nullable=false,unique=true)
    private Long eMP_ID;
	private String NAME;
	private long SALARY;
	private Date JOINED_ON;
    private String DEPARTMENT;
    
    @OneToMany(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JoinColumn(name="EMP_ID")
    private List<Assestmgnt> assestmgnt;
    
    @OneToOne(fetch = FetchType.EAGER,cascade =CascadeType.ALL)
    @JoinColumn(name="EMP_ID")
    private EmployeeDatiels empDetails;

     @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
     @JoinTable(name="EMP_ASSINGNMENTS",
     joinColumns = {@JoinColumn(name="EMP_ID")},
     inverseJoinColumns = {@JoinColumn(name="PR__ID")})
     private List<Project> empAssisgnmentList;
     
     
     
     
   
	public List<Assestmgnt> getAssestmgnt() {
		return assestmgnt;
	}
	public void setAssestmgnt(List<Assestmgnt> assestmgnt) {
		this.assestmgnt = assestmgnt;
	}
	public List<Project> getEmpAssisgnmentList() {
		return empAssisgnmentList;
	}
	public void setEmpAssisgnmentList(List<Project> empAssisgnmentList) {
		this.empAssisgnmentList = empAssisgnmentList;
	}
	public void seteMP_ID(Long eMP_ID) {
		this.eMP_ID = eMP_ID;
	}
	public EmployeeDatiels getEmpDetails() {
		return empDetails;
	}
	public void setEmpDetails(EmployeeDatiels empDetails) {
		this.empDetails = empDetails;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	
	public long geteMP_ID() {
		return eMP_ID;
	}
	public void seteMP_ID(long eMP_ID) {
		this.eMP_ID = eMP_ID;
	}
	public long getSALARY() {
		return SALARY;
	}
	public void setSALARY(long sALARY) {
		SALARY = sALARY;
	}
	public Date getJOINED_ON() {
		return JOINED_ON;
	}
	public void setJOINED_ON(Date jOINED_ON) {
		JOINED_ON = jOINED_ON;
	}
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}
	
	@Override
	public String toString() {
		return "Employee [eMP_ID=" + eMP_ID + ", NAME=" + NAME + ", SALARY=" + SALARY + ", JOINED_ON=" + JOINED_ON
				+ ", DEPARTMENT=" + DEPARTMENT + "]";
	}

	
	
}
