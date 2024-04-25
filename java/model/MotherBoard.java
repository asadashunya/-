package model;

import java.io.Serializable;

public class MotherBoard implements Serializable{
	private String motherboard_maker;
	private String motherboard_factor;
	private String motherboard_chipset;
	private String motherboard_name;
	private String motherboard_socket;
	private int motherboard_memory_slot;
	private int motherboard_memory_size;
	private int motherboard_socket_size;
	private String motherboard_ssd_standard;
	private int motherboard_price;
	private int motherboard_width;
	private int motherboard_depth;
	private String motherboard_img;
	private int motherboard_id;
	private int motherboard_recid;
	
	public MotherBoard() {
		super();
	}

	public MotherBoard(String motherboard_maker, String motherboard_factor, String motherboard_chipset,
			String motherboard_name, String motherboard_socket, int motherboard_memory_slot,
			int motherboard_memory_size, int motherboard_socket_size, String motherboard_ssd_standard,
			int motherboard_price, int motherboard_width, int motherboard_depth, String motherboard_img,
			int motherboard_id, int motherboard_recid) {
		super();
		this.motherboard_maker = motherboard_maker;
		this.motherboard_factor = motherboard_factor;
		this.motherboard_chipset = motherboard_chipset;
		this.motherboard_name = motherboard_name;
		this.motherboard_socket = motherboard_socket;
		this.motherboard_memory_slot = motherboard_memory_slot;
		this.motherboard_memory_size = motherboard_memory_size;
		this.motherboard_socket_size = motherboard_socket_size;
		this.motherboard_ssd_standard = motherboard_ssd_standard;
		this.motherboard_price = motherboard_price;
		this.motherboard_width = motherboard_width;
		this.motherboard_depth = motherboard_depth;
		this.motherboard_img = motherboard_img;
		this.motherboard_id = motherboard_id;
		this.motherboard_recid = motherboard_recid;
	}

	public String getMotherboard_maker() {
		return motherboard_maker;
	}

	public void setMotherboard_maker(String motherboard_maker) {
		this.motherboard_maker = motherboard_maker;
	}

	public String getMotherboard_factor() {
		return motherboard_factor;
	}

	public void setMotherboard_factor(String motherboard_factor) {
		this.motherboard_factor = motherboard_factor;
	}

	public String getMotherboard_chipset() {
		return motherboard_chipset;
	}

	public void setMotherboard_chipset(String motherboard_chipset) {
		this.motherboard_chipset = motherboard_chipset;
	}

	public String getMotherboard_name() {
		return motherboard_name;
	}

	public void setMotherboard_name(String motherboard_name) {
		this.motherboard_name = motherboard_name;
	}

	public String getMotherboard_socket() {
		return motherboard_socket;
	}

	public void setMotherboard_socket(String motherboard_socket) {
		this.motherboard_socket = motherboard_socket;
	}

	public int getMotherboard_memory_slot() {
		return motherboard_memory_slot;
	}

	public void setMotherboard_memory_slot(int motherboard_memory_slot) {
		this.motherboard_memory_slot = motherboard_memory_slot;
	}

	public int getMotherboard_memory_size() {
		return motherboard_memory_size;
	}

	public void setMotherboard_memory_size(int motherboard_memory_size) {
		this.motherboard_memory_size = motherboard_memory_size;
	}

	public int getMotherboard_socket_size() {
		return motherboard_socket_size;
	}

	public void setMotherboard_socket_size(int motherboard_socket_size) {
		this.motherboard_socket_size = motherboard_socket_size;
	}

	public String getMotherboard_ssd_standard() {
		return motherboard_ssd_standard;
	}

	public void setMotherboard_ssd_standard(String motherboard_ssd_standard) {
		this.motherboard_ssd_standard = motherboard_ssd_standard;
	}

	public int getMotherboard_price() {
		return motherboard_price;
	}

	public void setMotherboard_price(int motherboard_price) {
		this.motherboard_price = motherboard_price;
	}

	public int getMotherboard_width() {
		return motherboard_width;
	}

	public void setMotherboard_width(int motherboard_width) {
		this.motherboard_width = motherboard_width;
	}

	public int getMotherboard_depth() {
		return motherboard_depth;
	}

	public void setMotherboard_depth(int motherboard_depth) {
		this.motherboard_depth = motherboard_depth;
	}

	public String getMotherboard_img() {
		return motherboard_img;
	}

	public void setMotherboard_img(String motherboard_img) {
		this.motherboard_img = motherboard_img;
	}

	public int getMotherboard_id() {
		return motherboard_id;
	}

	public void setMotherboard_id(int motherboard_id) {
		this.motherboard_id = motherboard_id;
	}

	public int getMotherboard_recid() {
		return motherboard_recid;
	}

	public void setMotherboard_recid(int motherboard_recid) {
		this.motherboard_recid = motherboard_recid;
	}
	
}
