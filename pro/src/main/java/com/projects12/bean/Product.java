package com.projects12.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@Column(name="p_id")
	private int P_id;
	private String P_Name;
	private int Price;
	public int getP_id() {
		return P_id;
	}
	public void setP_id(int p_id) {
		P_id = p_id;
	}
	public String getP_Name() {
		return P_Name;
	}
	public void setP_Name(String p_Name) {
		P_Name = p_Name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "Product [P_id=" + P_id + ", P_Name=" + P_Name + ", Price=" + Price + "]";
	}

}
