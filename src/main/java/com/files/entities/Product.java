package com.files.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String pname;
	@Column(length=3000)
	private String pdesc;
	private String pphoto;
	private int pprice;
	private int pdiscount;
	private int pquantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;

	public Product(int pid, String pname, String pdesc, String pphoto, int pprice, int pdiscount, int pquantity,
			Category category) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdesc = pdesc;
		this.pphoto = pphoto;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.pquantity = pquantity;
		this.category = category;
	}

	public Product(String pname, String pdesc, String pphoto, int pprice, int pdiscount, int pquantity,
			Category category) {
		super();
		this.pname = pname;
		this.pdesc = pdesc;
		this.pphoto = pphoto;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.pquantity = pquantity;
		this.category = category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPphoto() {
		return pphoto;
	}

	public void setPphoto(String pphoto) {
		this.pphoto = pphoto;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPdiscount() {
		return pdiscount;
	}

	public void setPdiscount(int pdiscount) {
		this.pdiscount = pdiscount;
	}

	public int getPquantity() {
		return pquantity;
	}

	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", pphoto=" + pphoto + ", pprice="
				+ pprice + ", pdiscount=" + pdiscount + ", pquantity=" + pquantity + ", category=" + category + "]";
	}
	
	public int getPriceAfterDiscount() {
		int d= (int)((this.getPdiscount()/100.0)*this.getPprice());
		return this.getPprice()-d;
	}
	
}
