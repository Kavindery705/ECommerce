package com.files.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String uname;
	private String uemail;
	private String upassword;
	private long uphone;
	private String upic;
	@Column(length=1500)
	private String uaddress;
	private String type;
	public User(int id, String uname, String uemail, String upassword, long uphone, String upic, String uaddress,String type) {
		super();
		this.id = id;
		this.uname = uname;
		this.uemail = uemail;
		this.upassword = upassword;
		this.uphone = uphone;
		this.upic = upic;
		this.uaddress = uaddress;
		this.type=type;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String uname, String uemail, String upassword, long uphone, String upic, String uaddress,String type) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.upassword = upassword;
		this.uphone = uphone;
		this.upic = upic;
		this.uaddress = uaddress;
		this.type=type;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public long getUphone() {
		return uphone;
	}
	public void setUphone(long uphone) {
		this.uphone = uphone;
	}
	public String getUpic() {
		return upic;
	}
	public void setUpic(String upic) {
		this.upic = upic;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", uemail=" + uemail + ", upassword=" + upassword + ", uphone="
				+ uphone + ", upic=" + upic + ", uaddress=" + uaddress + "]";
	}
	
	
	
}
