package model;

import java.io.Serializable;

public class Memory implements Serializable{
	private String memory_name;
	private int memory_size;
	private String memory_standard;
	private int memory_volt;
	private int memory_price;
	private String memory_maker;
	private int memory_num;
	private String memory_img;
	private int memory_id;
	private int memory_recid;
	
	public Memory() {
		super();
	}

	public Memory(String memory_name, int memory_size, String memory_standard, int memory_volt, int memory_price,
			String memory_maker, int memory_num, String memory_img, int memory_id, int memory_recid) {
		super();
		this.memory_name = memory_name;
		this.memory_size = memory_size;
		this.memory_standard = memory_standard;
		this.memory_volt = memory_volt;
		this.memory_price = memory_price;
		this.memory_maker = memory_maker;
		this.memory_num = memory_num;
		this.memory_img = memory_img;
		this.memory_id = memory_id;
		this.memory_recid = memory_recid;
	}

	public String getMemory_name() {
		return memory_name;
	}

	public void setMemory_name(String memory_name) {
		this.memory_name = memory_name;
	}

	public int getMemory_size() {
		return memory_size;
	}

	public void setMemory_size(int memory_size) {
		this.memory_size = memory_size;
	}

	public String getMemory_standard() {
		return memory_standard;
	}

	public void setMemory_standard(String memory_standard) {
		this.memory_standard = memory_standard;
	}

	public int getMemory_volt() {
		return memory_volt;
	}

	public void setMemory_volt(int memory_volt) {
		this.memory_volt = memory_volt;
	}

	public int getMemory_price() {
		return memory_price;
	}

	public void setMemory_price(int memory_price) {
		this.memory_price = memory_price;
	}

	public String getMemory_maker() {
		return memory_maker;
	}

	public void setMemory_maker(String memory_maker) {
		this.memory_maker = memory_maker;
	}

	public int getMemory_num() {
		return memory_num;
	}

	public void setMemory_num(int memory_num) {
		this.memory_num = memory_num;
	}

	public String getMemory_img() {
		return memory_img;
	}

	public void setMemory_img(String memory_img) {
		this.memory_img = memory_img;
	}

	public int getMemory_id() {
		return memory_id;
	}

	public void setMemory_id(int memory_id) {
		this.memory_id = memory_id;
	}

	public int getMemory_recid() {
		return memory_recid;
	}

	public void setMemory_recid(int memory_recid) {
		this.memory_recid = memory_recid;
	}

	
	
}
