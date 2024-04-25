package model;

public class Ssd {
	private String ssd_name;
	private int ssd_capacity;
	private String ssd_standard;
	private String ssd_interface;
	private int ssd_price;
	private int ssd_power;
	private String ssd_maker;
	private int ssd_load;
	private int ssd_write;
	private String ssd_img;
	private int ssd_id;
	private int ssd_recid;
	
	public Ssd() {
		super();
	}

	public Ssd(String ssd_name, int ssd_capacity, String ssd_standard, String ssd_interface, int ssd_price,
			int ssd_power, String ssd_maker, int ssd_load, int ssd_write, String ssd_img, int ssd_id, int ssd_recid) {
		super();
		this.ssd_name = ssd_name;
		this.ssd_capacity = ssd_capacity;
		this.ssd_standard = ssd_standard;
		this.ssd_interface = ssd_interface;
		this.ssd_price = ssd_price;
		this.ssd_power = ssd_power;
		this.ssd_maker = ssd_maker;
		this.ssd_load = ssd_load;
		this.ssd_write = ssd_write;
		this.ssd_img = ssd_img;
		this.ssd_id = ssd_id;
		this.ssd_recid = ssd_recid;
	}

	public String getSsd_name() {
		return ssd_name;
	}

	public void setSsd_name(String ssd_name) {
		this.ssd_name = ssd_name;
	}

	public int getSsd_capacity() {
		return ssd_capacity;
	}

	public void setSsd_capacity(int ssd_capacity) {
		this.ssd_capacity = ssd_capacity;
	}

	public String getSsd_standard() {
		return ssd_standard;
	}

	public void setSsd_standard(String ssd_standard) {
		this.ssd_standard = ssd_standard;
	}

	public String getSsd_interface() {
		return ssd_interface;
	}

	public void setSsd_interface(String ssd_interface) {
		this.ssd_interface = ssd_interface;
	}

	public int getSsd_price() {
		return ssd_price;
	}

	public void setSsd_price(int ssd_price) {
		this.ssd_price = ssd_price;
	}

	public int getSsd_power() {
		return ssd_power;
	}

	public void setSsd_power(int ssd_power) {
		this.ssd_power = ssd_power;
	}

	public String getSsd_maker() {
		return ssd_maker;
	}

	public void setSsd_maker(String ssd_maker) {
		this.ssd_maker = ssd_maker;
	}

	public int getSsd_load() {
		return ssd_load;
	}

	public void setSsd_load(int ssd_load) {
		this.ssd_load = ssd_load;
	}

	public int getSsd_write() {
		return ssd_write;
	}

	public void setSsd_write(int ssd_write) {
		this.ssd_write = ssd_write;
	}

	public String getSsd_img() {
		return ssd_img;
	}

	public void setSsd_img(String ssd_img) {
		this.ssd_img = ssd_img;
	}

	public int getSsd_id() {
		return ssd_id;
	}

	public void setSsd_id(int ssd_id) {
		this.ssd_id = ssd_id;
	}

	public int getSsd_recid() {
		return ssd_recid;
	}

	public void setSsd_recid(int ssd_recid) {
		this.ssd_recid = ssd_recid;
	}

	
}
