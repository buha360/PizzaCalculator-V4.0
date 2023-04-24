package pizzas;

import java.util.Scanner;

public class Ingredients {

	Scanner scanner = new Scanner(System.in);
	
	private int weight;
	private int hydration;
	private int db;
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHydration() {
		return hydration;
	}
	public void setHydration(int hydration) {
		this.hydration = hydration;	
	}
	public int getDb() {
		return db;
	}
	public void setDb(int db) {
		this.db = db;
	}
	
	public Ingredients(double weight, int hydration, int db) {
		super();
		this.weight = (int) weight;
		this.hydration = hydration;
		this.db = db;
	}
	
	public int flour(int weight, int hydration) {
	    int flour;
	    double ratio = (1.22 - 1.18) / 8;
	    
	    if (hydration >= 61 && hydration <= 69) {
	        double difference = (hydration - 60) / 5.0;
	        flour = (int) ((weight / 2) * (1.22 - difference * ratio));
	    }else if (hydration == 60) {
	        flour = (int) ((weight / 2) * 1.22);
	    } else if (hydration == 65) {
	        flour = (int) ((weight / 2) * 1.20);
	    } else { // 70
	        flour = (int) ((weight / 2) * 1.18);
	    }

	    return flour;
	}

	
	public int water(int weight, int hydration) {
	    double proportion = (hydration - 60) / 10.0 * 0.04 + 0.74;
	    return (int) ((weight / 2) * proportion);
	}


	public int yeast (int weight) {
		int yeast = (int) (weight/60);
		return 	yeast;
	}
	
	public int salt (int weight, int hydration) {
		double water_minus_water = (100 - hydration);
		double delta = (1.96 - 1.45) / 7.0;
		double hydrationRatio = (hydration - 60) / 5.0;
		double divisor = 1.80 + delta * hydrationRatio;
		return (int) (weight / water_minus_water / divisor);
	}
	
	public double olive_oil (int db) {
		double olive_oil;
		
		if(db == 1) {
			olive_oil = 1;
		}else {
			olive_oil = 0.5;
		}
		return olive_oil;
	}
}