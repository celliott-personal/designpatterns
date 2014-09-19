package com.gof.patterns.decorator;

/**
 *   File      : TestDecoratorClient.java
 *   Author    : Chris Elliott
 *   Created   : 14-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   :
 */
public class TestDecoratorClient {
	/**
	 * @param ingredient
	 */
	public static  void printIngredient(Ingredient ingredient) {
		System.out.println("***** Ingredient *****");
		System.out.println("Description: " + ingredient.getItemName());
		System.out.println("Total Cost:  " + ingredient.getCost());
		System.out.println("***** The End *****");
		System.out.println("");
	} // printIngredient()
	
	public static void main(String[] args) {
		/*
		 * Setup an instance of a brown bread sandwich but using 
		 * the declaration type of an Ingredient.  The client in
		 * this instance does not need to know anything about the
		 * implementation.
		 */
		Ingredient sandwich = new BrownBreadSandwichImpl();
		printIngredient(sandwich);
		
		// Decorate the sandwich with a slice of cheese
		sandwich = new CheeseDecoratorImpl(sandwich);
		printIngredient(sandwich);
		
		// Add another slice to be greedy
		sandwich = new CheeseDecoratorImpl(sandwich);
		printIngredient(sandwich);
		
		// Finally, decorate the same sandwich again, but with tuna flakes
		sandwich = new TunaDecoratorImpl(sandwich);
		printIngredient(sandwich);
		
		/*
		 * Throughout each of the modifications to the sandwich, the api of
		 * functionality does not change.  The print routine still knows only
		 * of the ingredient, so with complicated class hierarchies, the power 
		 * and flexibility of this pattern is beginning to show.
		 */
	} // main()
} // TestDecoratorClient()