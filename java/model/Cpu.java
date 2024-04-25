package model;

import java.io.Serializable;

public class Cpu implements Serializable{
	private String cpu_name;
	private String cpu_processor;
	private String cpu_socket;
	private int cpu_cores;
	private int cpu_thread;
	private int cpu_ghz;
	private int cpu_price;
	private int cpu_power;
	private String cpu_img;
	private int cpu_id;
	private int cpu_recid;
	
	public Cpu() {
		super();
	}

	public Cpu(String cpu_name, String cpu_processor, String cpu_socket, int cpu_cores, int cpu_thread, int cpu_ghz,
			int cpu_price, int cpu_power, String cpu_img, int cpu_id, int cpu_recid) {
		super();
		this.cpu_name = cpu_name;
		this.cpu_processor = cpu_processor;
		this.cpu_socket = cpu_socket;
		this.cpu_cores = cpu_cores;
		this.cpu_thread = cpu_thread;
		this.cpu_ghz = cpu_ghz;
		this.cpu_price = cpu_price;
		this.cpu_power = cpu_power;
		this.cpu_img = cpu_img;
		this.cpu_id = cpu_id;
		this.cpu_recid = cpu_recid;
	}

	public String getCpu_name() {
		return cpu_name;
	}

	public void setCpu_name(String cpu_name) {
		this.cpu_name = cpu_name;
	}

	public String getCpu_processor() {
		return cpu_processor;
	}

	public void setCpu_processor(String cpu_processor) {
		this.cpu_processor = cpu_processor;
	}

	public String getCpu_socket() {
		return cpu_socket;
	}

	public void setCpu_socket(String cpu_socket) {
		this.cpu_socket = cpu_socket;
	}

	public int getCpu_cores() {
		return cpu_cores;
	}

	public void setCpu_cores(int cpu_cores) {
		this.cpu_cores = cpu_cores;
	}

	public int getCpu_thread() {
		return cpu_thread;
	}

	public void setCpu_thread(int cpu_thread) {
		this.cpu_thread = cpu_thread;
	}

	public int getCpu_ghz() {
		return cpu_ghz;
	}

	public void setCpu_ghz(int cpu_ghz) {
		this.cpu_ghz = cpu_ghz;
	}

	public int getCpu_price() {
		return cpu_price;
	}

	public void setCpu_price(int cpu_price) {
		this.cpu_price = cpu_price;
	}

	public int getCpu_power() {
		return cpu_power;
	}

	public void setCpu_power(int cpu_power) {
		this.cpu_power = cpu_power;
	}

	public String getCpu_img() {
		return cpu_img;
	}

	public void setCpu_img(String cpu_img) {
		this.cpu_img = cpu_img;
	}

	public int getCpu_id() {
		return cpu_id;
	}

	public void setCpu_id(int cpu_id) {
		this.cpu_id = cpu_id;
	}

	public int getCpu_recid() {
		return cpu_recid;
	}

	public void setCpu_recid(int cpu_recid) {
		this.cpu_recid = cpu_recid;
	}
	
}
