package model;

import java.io.Serializable;

public class Assembly implements Serializable{
	private String assembly_name;
	private int assembly_price;
	private String assembly_img;
	private String assembly_game;
	private String assembly_memory;
	private String assembly_power;
	private String assembly_graphic;
	private String assembly_cooler;
	private String assembly_box;
	private String assembly_motherboard;
	private String assembly_cpu;
	private String assembly_ssd;
	
	public Assembly() {
		super();
	}

	public Assembly(String assembly_name, int assembly_price, String assembly_img, String assembly_game,
			String assembly_memory, String assembly_power, String assembly_graphic, String assembly_cooler,
			String assembly_box, String assembly_motherboard, String assembly_cpu, String assembly_ssd) {
		super();
		this.assembly_name = assembly_name;
		this.assembly_price = assembly_price;
		this.assembly_img = assembly_img;
		this.assembly_game = assembly_game;
		this.assembly_memory = assembly_memory;
		this.assembly_power = assembly_power;
		this.assembly_graphic = assembly_graphic;
		this.assembly_cooler = assembly_cooler;
		this.assembly_box = assembly_box;
		this.assembly_motherboard = assembly_motherboard;
		this.assembly_cpu = assembly_cpu;
		this.assembly_ssd = assembly_ssd;
	}

	public String getAssembly_name() {
		return assembly_name;
	}

	public void setAssembly_name(String assembly_name) {
		this.assembly_name = assembly_name;
	}

	public int getAssembly_price() {
		return assembly_price;
	}

	public void setAssembly_price(int assembly_price) {
		this.assembly_price = assembly_price;
	}

	public String getAssembly_img() {
		return assembly_img;
	}

	public void setAssembly_img(String assembly_img) {
		this.assembly_img = assembly_img;
	}

	public String getAssembly_game() {
		return assembly_game;
	}

	public void setAssembly_game(String assembly_game) {
		this.assembly_game = assembly_game;
	}

	public String getAssembly_memory() {
		return assembly_memory;
	}

	public void setAssembly_memory(String assembly_memory) {
		this.assembly_memory = assembly_memory;
	}

	public String getAssembly_power() {
		return assembly_power;
	}

	public void setAssembly_power(String assembly_power) {
		this.assembly_power = assembly_power;
	}

	public String getAssembly_graphic() {
		return assembly_graphic;
	}

	public void setAssembly_graphic(String assembly_graphic) {
		this.assembly_graphic = assembly_graphic;
	}

	public String getAssembly_cooler() {
		return assembly_cooler;
	}

	public void setAssembly_cooler(String assembly_cooler) {
		this.assembly_cooler = assembly_cooler;
	}

	public String getAssembly_box() {
		return assembly_box;
	}

	public void setAssembly_box(String assembly_box) {
		this.assembly_box = assembly_box;
	}

	public String getAssembly_motherboard() {
		return assembly_motherboard;
	}

	public void setAssembly_motherboard(String assembly_motherboard) {
		this.assembly_motherboard = assembly_motherboard;
	}

	public String getAssembly_cpu() {
		return assembly_cpu;
	}

	public void setAssembly_cpu(String assembly_cpu) {
		this.assembly_cpu = assembly_cpu;
	}

	public String getAssembly_ssd() {
		return assembly_ssd;
	}

	public void setAssembly_ssd(String assembly_ssd) {
		this.assembly_ssd = assembly_ssd;
	}
	
	
}
