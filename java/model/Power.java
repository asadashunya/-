package model;

import java.io.Serializable;

public class Power implements Serializable{
	private String power_name;
	private String power_socket;
	private int power_capacity;
	private int power_price;
	private String power_plug;
	private String power_80plus;
	private String power_maker;
	private String power_img;
	private int power_width;
	private int power_height;
	private int power_depth;
	private int power_id;
	private int power_recid;
	
	public Power() {
		super();
	}
	
	public Power(String power_name, String power_socket, int power_capacity, int power_price, String power_plug,
			String power_80plus, String power_maker, String power_img, int power_width, int power_height,
			int power_depth, int power_id, int power_recid) {
		super();
		this.power_name = power_name;
		this.power_socket = power_socket;
		this.power_capacity = power_capacity;
		this.power_price = power_price;
		this.power_plug = power_plug;
		this.power_80plus = power_80plus;
		this.power_maker = power_maker;
		this.power_img = power_img;
		this.power_width = power_width;
		this.power_height = power_height;
		this.power_depth = power_depth;
		this.power_id = power_id;
		this.power_recid = power_recid;
	}

	public String getPower_name() {
		return power_name;
	}

	public void setPower_name(String power_name) {
		this.power_name = power_name;
	}

	public String getPower_socket() {
		return power_socket;
	}

	public void setPower_socket(String power_socket) {
		this.power_socket = power_socket;
	}

	public int getPower_capacity() {
		return power_capacity;
	}

	public void setPower_capacity(int power_capacity) {
		this.power_capacity = power_capacity;
	}

	public int getPower_price() {
		return power_price;
	}

	public void setPower_price(int power_price) {
		this.power_price = power_price;
	}

	public String getPower_plug() {
		return power_plug;
	}

	public void setPower_plug(String power_plug) {
		this.power_plug = power_plug;
	}

	public String getPower_80plus() {
		return power_80plus;
	}

	public void setPower_80plus(String power_80plus) {
		this.power_80plus = power_80plus;
	}

	public String getPower_maker() {
		return power_maker;
	}

	public void setPower_maker(String power_maker) {
		this.power_maker = power_maker;
	}

	public String getPower_img() {
		return power_img;
	}

	public void setPower_img(String power_img) {
		this.power_img = power_img;
	}

	public int getPower_width() {
		return power_width;
	}

	public void setPower_width(int power_width) {
		this.power_width = power_width;
	}

	public int getPower_height() {
		return power_height;
	}

	public void setPower_height(int power_height) {
		this.power_height = power_height;
	}

	public int getPower_depth() {
		return power_depth;
	}

	public void setPower_depth(int power_depth) {
		this.power_depth = power_depth;
	}

	public int getPower_id() {
		return power_id;
	}

	public void setPower_id(int power_id) {
		this.power_id = power_id;
	}

	public int getPower_recid() {
		return power_recid;
	}

	public void setPower_recid(int power_recid) {
		this.power_recid = power_recid;
	}
	
	
}
