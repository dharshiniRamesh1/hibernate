package com.bean;

public class Studentdetails {
	
	
	private int S_id;
    private String Name;
	private String Address;
	
	
	public Studentdetails(int s_id, String name, String address) {
		super();
		S_id = s_id;
		Name = name;
		Address = address;
	}


	public int getS_id() {
		return S_id;
	}


	public void setS_id(int s_id) {
		S_id = s_id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	@Override
	public String toString() {
		return "Studentdetails [S_id=" + S_id + ", Name=" + Name + ", Address=" + Address +"]";
	}
}
