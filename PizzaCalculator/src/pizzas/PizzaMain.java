package pizzas;

import java.util.Scanner;

public class PizzaMain {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/*
		if(choose_pizza()) {
			//ide jönnek a Neapolitan pizza functionok
			Ingredients ingredients = new Ingredients(weight_neapolitan(), hydration(), dbs());
			Poolish poolish = new Poolish(ingredients.flour(ingredients.getWeight(), ingredients.getHydration()), ingredients.water(ingredients.getWeight(), ingredients.getHydration()), ingredients.yeast(ingredients.getWeight()),  ingredients.getDb());
			Neapolitan neapolitan = new Neapolitan(poolish.getFlour(), poolish.getWater(), poolish.getYeast(),  ingredients.olive_oil(ingredients.getDb()), ingredients.salt(ingredients.getWeight(), ingredients.getHydration()), ingredients.getDb());
			
			System.out.println("------------------------------------");
			System.out.println(neapolitan.getFlour());
			System.out.println(neapolitan.getOlive_oil());
			System.out.println(neapolitan.getSalt());
			System.out.println(neapolitan.getWater());
			System.out.println(neapolitan.getYeast());
		}else {
			//ide jönnek a Sheet pizza functionok
			Ingredients ingredients = new Ingredients((sheet_a()*sheet_b())/sheet_thickness(), hydration(), dbs());
			Poolish poolish = new Poolish(ingredients.flour(ingredients.getWeight(), ingredients.getHydration()), ingredients.water(ingredients.getWeight(), ingredients.getHydration()), ingredients.yeast(ingredients.getWeight()),  ingredients.getDb());
			Sheet sheet = new Sheet(poolish.getFlour(), poolish.getWater(), poolish.getYeast(), ingredients.olive_oil(ingredients.getDb()), ingredients.salt(ingredients.getWeight(), ingredients.getHydration()));
			
			System.out.println("------------------------------------");
			System.out.println(sheet.getFlour());
			System.out.println(sheet.getOlive_oil());
			System.out.println(sheet.getSalt());
			System.out.println(sheet.getWater());
			System.out.println(sheet.getYeast());
		}
		*/
	}
	
	public static Boolean choose_pizza () {
		System.out.println("------------------------------------");
		String answer = null;
		Boolean ok = false;
		Boolean type = false;
		
		do {
			System.out.println("Melyik pizzat szeretned elkesziteni ? (Napolyi/Romai)");
			while (scanner.hasNextInt()) {
				System.out.println("Ird be a nevet!");
				scanner.next();
			}
			answer = scanner.next();
			scanner.nextLine();
			
			if (answer.equalsIgnoreCase("Napolyi") || answer.equalsIgnoreCase("Nápolyi")) {
			   ok = true;
			   type = true;
			} else if(answer.equalsIgnoreCase("Romai") || answer.equalsIgnoreCase("Római")) {
			   ok = true;
			}
			
		}while(!ok);
		return type;
	}
	
	public static int weight_neapolitan (int weight) {
		System.out.println("------------------------------------");
		
		do {
			System.out.println("Mekkora pizzat/pizzakat szeretnel?");
			System.out.println(" 320-340 (kicsi) <30cm");
			System.out.println(" 340-380 (normal) ~32cm");
			System.out.println(" 390-440 (nagy) >34cm");
			while (!scanner.hasNextInt()) {System.out.println("Csak egy szamot adj meg!");
				scanner.next();
			}
			weight = scanner.nextInt();
			scanner.nextLine();
		} while (weight < 280 || weight > 450);
		return weight;
	}
	
	public static int hydration (int hydration) {
		System.out.println("------------------------------------");
		
		do {
			System.out.println("Valassz 60 - 65 - 70 %-os hidratacio kozul! --");
			System.out.println("Ha kezdo vagy ajanlom a 60%-t! --");
			while (!scanner.hasNextInt()) {
				System.out.println("Ketjegyu szamot adj meg!");
				scanner.next();
			}
			hydration = scanner.nextInt();
			scanner.nextLine();
		} while (hydration < 60 || hydration > 70);
		return hydration;
	}
	
	public static int dbs (int db) {
		System.out.println("------------------------------------");
		
		do {
			System.out.println("Mennyi pizzat szeretnel kesziteni?");
			while (!scanner.hasNextInt()) {
				System.out.println("Csak egy szamot adj meg!");
				scanner.next();
			}
			db = scanner.nextInt();
			scanner.nextLine();
		} while (db < 0);
		return db;
	}
	
	public static int sheet_a() {
		System.out.println("------------------------------------");
		int a = 0;

		do {
			System.out.println("Adja meg a tepsi egyik oldalat!");
			while (!scanner.hasNextInt()) {
				System.out.println("Csak egy szamot adj meg!");
				scanner.next();
			}
			a = scanner.nextInt();
			scanner.nextLine();
		} while (a < 0);
		return a;
	}

	public static int sheet_b() {
		System.out.println("------------------------------------");
		int b = 0;

		do {
			System.out.println("Adja meg a tepsi masik odlalat!");
			while (!scanner.hasNextInt()) {
				System.out.println("Csak egy szamot adj meg!");
				scanner.next();
			}
			b = scanner.nextInt();
			scanner.nextLine();
		} while (b < 0);
		return b;
	}

	public static double sheet_thickness() {
		System.out.println("------------------------------------");
		int thickness = 0;
		
		do {
			System.out.println("Mennyire legyen vastag ? 150-200 kozott valasszon szamot!");
			while (!scanner.hasNextInt()) {
				System.out.println("Csak egy szamot adj meg!");
				scanner.next();
			}
			thickness = scanner.nextInt();
			scanner.nextLine();
		} while (thickness < 150 || thickness > 200);
		
		double returnThickness = (double) thickness / 100;
		return returnThickness;
	}
	
}
