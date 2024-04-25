package model;

import java.io.Serializable;

public class Cooler implements Serializable{
	private String cooler_name;
	private String cooler_socket;
	private int cooler_price;
	private int cooler_power;
	private String cooler_maker;
	private int cooler_fans;
	private int cooler_conector;
	private String cooler_img;
	private int cooler_depth;
	private int cooler_height;
	private int cooler_width;
	private int cooler_id;
	private int cooler_recid;
	
	public Cooler() {
		super();
	}
	
	public Cooler(String cooler_name, String cooler_socket, int cooler_price, int cooler_power, String cooler_maker,
			int cooler_fans, int cooler_conector, String cooler_img, int cooler_depth, int cooler_height,
			int cooler_width, int cooler_id, int cooler_recid) {
		super();
		this.cooler_name = cooler_name;
		this.cooler_socket = cooler_socket;
		this.cooler_price = cooler_price;
		this.cooler_power = cooler_power;
		this.cooler_maker = cooler_maker;
		this.cooler_fans = cooler_fans;
		this.cooler_conector = cooler_conector;
		this.cooler_img = cooler_img;
		this.cooler_depth = cooler_depth;
		this.cooler_height = cooler_height;
		this.cooler_width = cooler_width;
		this.cooler_id = cooler_id;
		this.cooler_recid = cooler_recid;
	}

	public String getCooler_name() {
		return cooler_name;
	}

	public void setCooler_name(String cooler_name) {
		this.cooler_name = cooler_name;
	}

	public String getCooler_socket() {
		return cooler_socket;
	}

	public void setCooler_socket(String cooler_socket) {
		this.cooler_socket = cooler_socket;
	}

	public int getCooler_price() {
		return cooler_price;
	}

	public void setCooler_price(int cooler_price) {
		this.cooler_price = cooler_price;
	}

	public int getCooler_power() {
		return cooler_power;
	}

	public void setCooler_power(int cooler_power) {
		this.cooler_power = cooler_power;
	}

	public String getCooler_maker() {
		return cooler_maker;
	}

	public void setCooler_maker(String cooler_maker) {
		this.cooler_maker = cooler_maker;
	}

	public int getCooler_fans() {
		return cooler_fans;
	}

	public void setCooler_fans(int cooler_fans) {
		this.cooler_fans = cooler_fans;
	}

	public int getCooler_conector() {
		return cooler_conector;
	}

	public void setCooler_conector(int cooler_connector) {
		this.cooler_conector = cooler_connector;
	}

	public String getCooler_img() {
		return cooler_img;
	}

	public void setCooler_img(String cooler_img) {
		this.cooler_img = cooler_img;
	}

	public int getCooler_depth() {
		return cooler_depth;
	}

	public void setCooler_depth(int cooler_depth) {
		this.cooler_depth = cooler_depth;
	}

	public int getCooler_height() {
		return cooler_height;
	}

	public void setCooler_height(int cooler_height) {
		this.cooler_height = cooler_height;
	}

	public int getCooler_width() {
		return cooler_width;
	}

	public void setCooler_width(int cooler_width) {
		this.cooler_width = cooler_width;
	}

	public int getCooler_id() {
		return cooler_id;
	}

	public void setCooler_id(int cooler_id) {
		this.cooler_id = cooler_id;
	}

	public int getCooler_recid() {
		return cooler_recid;
	}

	public void setCooler_recid(int cooler_recid) {
		this.cooler_recid = cooler_recid;
	}
	
	
}
