package model;

import java.io.Serializable;

public class Graphicsboard implements Serializable{
	private String graphic_name;
	private String graphic_chip;
	private String graphic_memory;
	private String graphic_monitor;
	private String graphic_cool;
	private int graphic_clock;
	private int graphic_price;
	private int graphic_power;
	private String graphic_maker;
	private String graphic_img;
	
	public Graphicsboard() {
		super();
	}

	public Graphicsboard(String graphic_name, String graphic_chip, String graphic_memory, String graphic_monitor,
			String graphic_cool, int graphic_clock, int graphic_price, int graphic_power, String graphic_maker,
			String graphic_img) {
		super();
		this.graphic_name = graphic_name;
		this.graphic_chip = graphic_chip;
		this.graphic_memory = graphic_memory;
		this.graphic_monitor = graphic_monitor;
		this.graphic_cool = graphic_cool;
		this.graphic_clock = graphic_clock;
		this.graphic_price = graphic_price;
		this.graphic_power = graphic_power;
		this.graphic_maker = graphic_maker;
		this.graphic_img = graphic_img;
	}

	public String getGraphic_name() {
		return graphic_name;
	}

	public void setGraphic_name(String graphic_name) {
		this.graphic_name = graphic_name;
	}

	public String getGraphic_chip() {
		return graphic_chip;
	}

	public void setGraphic_chip(String graphic_chip) {
		this.graphic_chip = graphic_chip;
	}

	public String getGraphic_memory() {
		return graphic_memory;
	}

	public void setGraphic_memory(String graphic_memory) {
		this.graphic_memory = graphic_memory;
	}

	public String getGraphic_monitor() {
		return graphic_monitor;
	}

	public void setGraphic_monitor(String graphic_monitor) {
		this.graphic_monitor = graphic_monitor;
	}

	public String getGraphic_cool() {
		return graphic_cool;
	}

	public void setGraphic_cool(String graphic_cool) {
		this.graphic_cool = graphic_cool;
	}

	public int getGraphic_clock() {
		return graphic_clock;
	}

	public void setGraphic_clock(int graphic_clock) {
		this.graphic_clock = graphic_clock;
	}

	public int getGraphic_price() {
		return graphic_price;
	}

	public void setGraphic_price(int graphic_price) {
		this.graphic_price = graphic_price;
	}

	public int getGraphic_power() {
		return graphic_power;
	}

	public void setGraphic_power(int graphic_power) {
		this.graphic_power = graphic_power;
	}

	public String getGraphic_maker() {
		return graphic_maker;
	}

	public void setGraphic_maker(String graphic_maker) {
		this.graphic_maker = graphic_maker;
	}

	public String getGraphic_img() {
		return graphic_img;
	}

	public void setGraphic_img(String graphic_img) {
		this.graphic_img = graphic_img;
	}
	
}
