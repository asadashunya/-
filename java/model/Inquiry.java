package model;

import java.io.Serializable;

public class Inquiry implements Serializable{
	private int inquiry_id;
	private String inquiry_main;
	private String inquiry_name;
	private int inquiry_tel;
	private String inquiry_mail;
	private String inquiry_title;
	
	public Inquiry() {
		super();
	}
	
	public Inquiry(int inquiry_id , String inquiry_main , String inquiry_name, int inquiry_tel , String inquiry_mail , String inquiry_title) {
		this.inquiry_id = inquiry_id;
		this.inquiry_main = inquiry_main;
		this.inquiry_name = inquiry_name;
		this.inquiry_tel = inquiry_tel;
		this.inquiry_mail = inquiry_mail;
		this.inquiry_title = inquiry_title;
	}

	public String getInquiry_main() {
		return inquiry_main;
	}

	public void setInquiry_main(String inquiry_main) {
		this.inquiry_main = inquiry_main;
	}

	public String getInquiry_name() {
		return inquiry_name;
	}

	public void setInquiry_name(String inquiry_name) {
		this.inquiry_name = inquiry_name;
	}

	public int getInquiry_tel() {
		return inquiry_tel;
	}

	public void setInquiry_tel(int inquiry_tel) {
		this.inquiry_tel = inquiry_tel;
	}

	public String getInquiry_mail() {
		return inquiry_mail;
	}

	public void setInquiry_mail(String inquiry_mail) {
		this.inquiry_mail = inquiry_mail;
	}

	public String getInquiry_title() {
		return inquiry_title;
	}

	public void setInquiry_title(String inquiry_title) {
		this.inquiry_title = inquiry_title;
	}

	public int getInquiry_id() {
		return inquiry_id;
	}

	public void setInquiry_id(int inquiry_id) {
		this.inquiry_id = inquiry_id;
	}
	
}

