package pizzas;

import java.util.Scanner;

public class Poolish {
	
	Scanner scanner = new Scanner(System.in);
	
	private int flour;
	private int water;
	private int yeast;
	
	public int getFlour() {
		return flour;
	}
	public void setFlour(int flour) {
		this.flour = flour;
	}
	public int getWater() {	
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public int getYeast() {
		return yeast;
	}
	public void setYeast(int yeast) {
		this.yeast = yeast;
	}
	
	public Poolish(int flour, int water, int yeast, int db) {
		super();
		this.flour = flour * db;
		this.water = water * db;
		this.yeast = yeast * db;
	}
}