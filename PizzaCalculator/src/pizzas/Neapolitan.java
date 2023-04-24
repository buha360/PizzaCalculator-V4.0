package pizzas;

public class Neapolitan {
	
	private double flour;
	private double water;
	private double yeast;
	private double olive_oil;
	private double salt;
	
	public double getFlour() {
		return flour;
	}
	public void setFlour(double flour) {
		this.flour = flour;
	}
	public double getWater() {
		return water;
	}
	public void setWater(double water) {
		this.water = water;
	}
	public double getYeast() {
		return yeast;
	}
	public void setYeast(double yeast) {
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
	public void setSalt(double salt) {	
		this.salt = salt;
	}
	
	public Neapolitan(double flour, double water, double yeast, double olive_oil, int salt, int db) {
		super();
		this.flour = flour;
		this.water = water;
		this.yeast = yeast;
		
		if(db > 2) {
			this.olive_oil = Math.floor((olive_oil * db) * 1.5);
		}else if (db == 2) {
			this.olive_oil = 2;
		}else {
			this.olive_oil = olive_oil * db;
		}
		
		this.salt = salt * db;
	}
	
}
