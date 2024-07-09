package com.projects12.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name ="EMP_DETAILS")
public class EmployeeDatiels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID", unique = true, nullable = false)
    private Long empid;


	private String address;
	private String gender;
	@Column(name="YEARS_OF_SERVICE")
	private long yearsofservice;
	@Column(name="BANK_ACCOUNT")
	private String bankaccount;
	
	
	public Long getEmpid() {
        return empid;
    }

    public void setEmpid(Long empid) {
        this.empid = empid;
    }

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getYearsofservice() {
		return yearsofservice;
	}
	public void setYearsofservice(long yearsofservice) {
		this.yearsofservice = yearsofservice;
	}
	public String getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}
	@Override
	public String toString() {
		return "EmployeeDatiels [empid=" + empid + ", address=" + address + ", gender=" + gender + ", yearsofservice="
				+ yearsofservice + ", bankaccount=" + bankaccount + "]";
	}

}
