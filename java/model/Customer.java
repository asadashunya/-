package model;

import java.io.Serializable;

public class Customer implements Serializable{
	private int cust_num;
	private String cust_fname;
	private String cust_lname;
	private String cust_fkana;
	private String cust_lkana;
	private String cust_tel;
	private String cust_address;
	private String cust_mail;
	private String cust_username;
	private int cust_postnum;


	public Customer() {
		super();
	}
	
	public Customer(int cust_num,String cust_fname,String cust_lname,String cust_fkana, String cust_lkana, 
			String cust_tel , String cust_address , String cust_mail, String cust_username, int cust_postnum) {
		super();
		this.cust_num = cust_num;
		this.cust_fname = cust_fname;
		this.cust_lname = cust_lname;
		this.cust_fkana = cust_fkana;
		this.cust_lkana = cust_lkana;
		this.cust_tel = cust_tel;
		this.cust_address = cust_address;
		this.cust_mail = cust_mail;
		this.cust_username = cust_username;
		this.cust_postnum = cust_postnum;
		
	}
	
	public int getCust_postnum() {
		return cust_postnum;
	}

	public void setCust_postnum(int cust_postnum) {
		this.cust_postnum = cust_postnum;
	}

	public int getCust_num() {
		return cust_num;
	}
	
	public void setCust_num(int cust_num) {
		this.cust_num = cust_num;
	}
	

	public String getCust_fname() {
		return cust_fname;
	}

	public void setCust_fname(String cust_fname) {
		this.cust_fname = cust_fname;
	}

	public String getCust_lname() {
		return cust_lname;
	}

	public void setCust_lname(String cust_lname) {
		this.cust_lname = cust_lname;
	}

	public String getCust_fkana() {
		return cust_fkana;
	}

	public void setCust_fkana(String cust_fkana) {
		this.cust_fkana = cust_fkana;
	}

	public String getCust_lkana() {
		return cust_lkana;
	}

	public void setCust_lkana(String cust_lkana) {
		this.cust_lkana = cust_lkana;
	}

	public String getCust_tel() {
		return cust_tel;
	}

	public void setCust_tel(String cust_tel) {
		this.cust_tel = cust_tel;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public String getCust_mail() {
		return cust_mail;
	}

	public void setCust_mail(String cust_mail) {
		this.cust_mail = cust_mail;
	}

	public String getCust_username() {
		return cust_username;
	}

	public void setCust_username(String cust_username) {
		this.cust_username = cust_username;
	}
}
