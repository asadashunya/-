package model;

import java.io.Serializable;

public class Consul implements Serializable{
	private int consul_id;
	private int consul_mitumori;
	private String consul_content;
	private int consul_customer;
	
	public Consul() {
		super();
	}
	
	public Consul(int consul_id , int consul_mitumori , String consul_content, int consul_customer) {
		this.consul_id = consul_id;
		this.consul_mitumori = consul_mitumori;
		this.consul_content = consul_content;
		this.consul_customer = consul_customer;
	}

	public int getConsul_id() {
		return consul_id;
	}

	public void setConsul_id(int consul_id) {
		this.consul_id = consul_id;
	}

	public int getConsul_mitumori() {
		return consul_mitumori;
	}

	public void setConsul_mitumori(int consul_mitumori) {
		this.consul_mitumori = consul_mitumori;
	}

	public String getConsul_content() {
		return consul_content;
	}

	public void setConsul_content(String consul_content) {
		this.consul_content = consul_content;
	}

	public int getConsul_customer() {
		return consul_customer;
	}

	public void setConsul_customer(int consul_customer) {
		this.consul_customer = consul_customer;
	}
	
}