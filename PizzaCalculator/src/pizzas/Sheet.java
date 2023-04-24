package pizzas;

public class Sheet {

	private int flour;
	private int water;
	private int yeast;
	private double olive_oil;
	private int salt;
	
	public double getFlour() {
		return flour;
	}
	public void setFlour(int flour) {
		this.flour = flour;
	}
	public double getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public double getYeast() {
		return yeast;
	}
	public void setYeast(int yeast) {
		this.yeast = yeast;
	}
	public double getOlive_oil() {
		return olive_oil;
	}
	public void setOlive_oil(double olive_oil) {
		this.olive_oil = olive_oil;
	}
	public double getSalt() {
		return salt;
	}
	public void setSalt(int salt) {
		this.salt = salt;
	}
	
	public Sheet(int flour, int water, int yeast, double olive_oil, int salt) {
		super();
		this.flour = flour;
		this.water = water;
		this.yeast = yeast;
		this.olive_oil = olive_oil * 2;	
		this.salt = salt;
	}
}
