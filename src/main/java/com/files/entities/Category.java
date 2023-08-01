package com.files.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String ctitle;
	@Column(length=3000)
	private String cdesc;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	private List<Product> products = new ArrayList<Product>();
	public Category(int cid, String ctitle, String cdesc) {
		super();
		this.cid = cid;
		this.ctitle = ctitle;
		this.cdesc = cdesc;
	}
	
	public Category(int cid, String ctitle, String cdesc, List<Product> products) {
		super();
		this.cid = cid;
		this.ctitle = ctitle;
		this.cdesc = cdesc;
		this.products = products;
	}

	public Category(String ctitle, String cdesc) {
		super();
		this.ctitle = ctitle;
		this.cdesc = cdesc;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", ctitle=" + ctitle + ", cdesc=" + cdesc + "]";
	}
	
	
}
