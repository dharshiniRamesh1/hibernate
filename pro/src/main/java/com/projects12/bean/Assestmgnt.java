package com.projects12.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ASSET_MNGT")
public class Assestmgnt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="AM_ID",nullable=false,unique=true)
	private long am_ID;
	private int EMP_ID;
	private String ASSET_NAME;
	private String VANDAR;
	public long getAm_ID() {
		return am_ID;
	}
	public void setAm_ID(long am_ID) {
		this.am_ID = am_ID;
	}
	public int getEMP_ID() {
		return EMP_ID;
	}
	public void setEMP_ID(int eMP_ID) {
		EMP_ID = eMP_ID;
	}
	public String getASSET_NAME() {
		return ASSET_NAME;
	}
	public void setASSET_NAME(String aSSET_NAME) {
		ASSET_NAME = aSSET_NAME;
	}
	public String getVANDAR() {
		return VANDAR;
	}
	public void setVANDAR(String vANDAR) {
		VANDAR = vANDAR;
	}
	@Override
	public String toString() {
		return "Assestmgnt [am_ID=" + am_ID + ", EMP_ID=" + EMP_ID + ", ASSET_NAME=" + ASSET_NAME + ", VANDAR=" + VANDAR
				+ "]";
	}

}
