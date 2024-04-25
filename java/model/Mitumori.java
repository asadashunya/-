package model;

import java.io.Serializable;

public class Mitumori implements Serializable{
	private int mitumori_id;
	private String mitumori_memory;
	private String mitumori_power;
	private String mitumori_graphic;
	private String mitumori_cooler;
	private String mitumori_box;
	private String mitumori_motherboard;
	private String mitumori_cpu;
	private String mitumori_ssd;
	private String mitumori_keyboard;
	private String mitumori_mouse;
	
	public Mitumori() {
		super();
	}

	public Mitumori(int mitumori_id, String mitumori_memory, String mitumori_power, String mitumori_graphic,
			String mitumori_cooler, String mitumori_box, String mitumori_motherboard, String mitumori_cpu,
			String mitumori_ssd, String mitumori_keyboard, String mitumori_mouse) {
		super();
		this.mitumori_id = mitumori_id;
		this.mitumori_memory = mitumori_memory;
		this.mitumori_power = mitumori_power;
		this.mitumori_graphic = mitumori_graphic;
		this.mitumori_cooler = mitumori_cooler;
		this.mitumori_box = mitumori_box;
		this.mitumori_motherboard = mitumori_motherboard;
		this.mitumori_cpu = mitumori_cpu;
		this.mitumori_ssd = mitumori_ssd;
		this.mitumori_keyboard = mitumori_keyboard;
		this.mitumori_mouse = mitumori_mouse;
	}

	public int getMitumori_id() {
		return mitumori_id;
	}

	public void setMitumori_id(int mitumori_id) {
		this.mitumori_id = mitumori_id;
	}

	public String getMitumori_memory() {
		return mitumori_memory;
	}

	public void setMitumori_memory(String mitumori_memory) {
		this.mitumori_memory = mitumori_memory;
	}

	public String getMitumori_power() {
		return mitumori_power;
	}

	public void setMitumori_power(String mitumori_power) {
		this.mitumori_power = mitumori_power;
	}

	public String getMitumori_graphic() {
		return mitumori_graphic;
	}

	public void setMitumori_graphic(String mitumori_graphic) {
		this.mitumori_graphic = mitumori_graphic;
	}

	public String getMitumori_cooler() {
		return mitumori_cooler;
	}

	public void setMitumori_cooler(String mitumori_cooler) {
		this.mitumori_cooler = mitumori_cooler;
	}

	public String getMitumori_box() {
		return mitumori_box;
	}

	public void setMitumori_box(String mitumori_box) {
		this.mitumori_box = mitumori_box;
	}

	public String getMitumori_motherboard() {
		return mitumori_motherboard;
	}

	public void setMitumori_motherboard(String mitumori_motherboard) {
		this.mitumori_motherboard = mitumori_motherboard;
	}

	public String getMitumori_cpu() {
		return mitumori_cpu;
	}

	public void setMitumori_cpu(String mitumori_cpu) {
		this.mitumori_cpu = mitumori_cpu;
	}

	public String getMitumori_ssd() {
		return mitumori_ssd;
	}

	public void setMitumori_ssd(String mitumori_ssd) {
		this.mitumori_ssd = mitumori_ssd;
	}

	public String getMitumori_keyboard() {
		return mitumori_keyboard;
	}

	public void setMitumori_keyboard(String mitumori_keyboard) {
		this.mitumori_keyboard = mitumori_keyboard;
	}

	public String getMitumori_mouse() {
		return mitumori_mouse;
	}

	public void setMitumori_mouse(String mitumori_mouse) {
		this.mitumori_mouse = mitumori_mouse;
	}
	
}
