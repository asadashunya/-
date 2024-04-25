package model;

import java.io.Serializable;

public class Box implements Serializable{
	private String box_name;
	private String box_size;
	private String box_water;
	private String box_mother;
	private int box_cpu;
	private int box_graphic;
	private int box_power;
	private int box_price;
	private String box_maker;
	private String box_img;
	private int box_id;
	private int box_recid;
	
	public Box() {
		super();
	}

	public Box(String box_name, String box_size, String box_water, String box_mother, int box_cpu, int box_graphic,
			int box_power, int box_price, String box_maker, String box_img, int box_id, int box_recid) {
		super();
		this.box_name = box_name;
		this.box_size = box_size;
		this.box_water = box_water;
		this.box_mother = box_mother;
		this.box_cpu = box_cpu;
		this.box_graphic = box_graphic;
		this.box_power = box_power;
		this.box_price = box_price;
		this.box_maker = box_maker;
		this.box_img = box_img;
		this.box_id = box_id;
		this.box_recid = box_recid;
	}

	public String getBox_name() {
		return box_name;
	}

	public void setBox_name(String box_name) {
		this.box_name = box_name;
	}

	public String getBox_size() {
		return box_size;
	}

	public void setBox_size(String box_size) {
		this.box_size = box_size;
	}

	public String getBox_water() {
		return box_water;
	}

	public void setBox_water(String box_water) {
		this.box_water = box_water;
	}

	public String getBox_mother() {
		return box_mother;
	}

	public void setBox_mother(String box_mother) {
		this.box_mother = box_mother;
	}

	public int getBox_cpu() {
		return box_cpu;
	}

	public void setBox_cpu(int box_cpu) {
		this.box_cpu = box_cpu;
	}

	public int getBox_graphic() {
		return box_graphic;
	}

	public void setBox_graphic(int box_graphic) {
		this.box_graphic = box_graphic;
	}

	public int getBox_power() {
		return box_power;
	}

	public void setBox_power(int box_power) {
		this.box_power = box_power;
	}

	public int getBox_price() {
		return box_price;
	}

	public void setBox_price(int box_price) {
		this.box_price = box_price;
	}

	public String getBox_maker() {
		return box_maker;
	}

	public void setBox_maker(String box_maker) {
		this.box_maker = box_maker;
	}

	public String getBox_img() {
		return box_img;
	}

	public void setBox_img(String box_img) {
		this.box_img = box_img;
	}

	public int getBox_id() {
		return box_id;
	}

	public void setBox_id(int box_id) {
		this.box_id = box_id;
	}

	public int getBox_recid() {
		return box_recid;
	}

	public void setBox_recid(int box_recid) {
		this.box_recid = box_recid;
	}

	
}

