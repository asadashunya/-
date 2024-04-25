package model;

import java.io.Serializable;

public class Order implements Serializable{
	private int order_id;
	private String order_customer;
	private String order_date;
	private int order_price;
	private int order_mitumori;
	private String order_assembly;

    public Order() {
        super();
    }
    
    public Order(int order_id , String order_customer , 
    		String order_date , int order_price , 
    		int order_mitumori, String order_assembly) {
    	
    	this.order_id = order_id;
    	this.order_customer = order_customer;
    	this.order_date = order_date;
    	this.order_price = order_price;
    	this.order_mitumori = order_mitumori;
    	this.order_assembly = order_assembly;
    	
    }

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_customer() {
		return order_customer;
	}

	public void setOrder_customer(String order_customer) {
		this.order_customer = order_customer;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	public int getOrder_mitumori() {
		return order_mitumori;
	}

	public void setOrder_mitumori(int order_mitumori) {
		this.order_mitumori = order_mitumori;
	}

	public String getOrder_assembly() {
		return order_assembly;
	}

	public void setOrder_assembly(String order_assembly) {
		this.order_assembly = order_assembly;
	}
    
    }
