package com.gof.patterns.decorator;

import java.math.BigDecimal;

/**
 *   File      : AbstractIngredientDecorator.java
 *   Author    : Chris Elliott
 *   Created   : 14-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   : The <code>AbstractIngredientDecorator</code> abstract class provides
 *               a skeleton implementation to be able to wrap a given base type of
 *               <code>Ingredient</code>.
 *               
 *               The aim will be to eventually provide extra functionality without
 *               having to change other classes within the model.
 */
public abstract class AbstractIngredientDecorator implements Ingredient {
	private final Ingredient ingredient;
	
	public AbstractIngredientDecorator(final Ingredient ingredient) {
		this.ingredient = ingredient;
	} // AbstractIngredientDecorator()
	
	/**
	 * @return wrapped item name
	 */
	@Override
	public String getItemName() {
		return ingredient.getItemName();
	} // getItemName()
	
	/**
	 * @return wrapped item cost
	 */
	@Override
	public BigDecimal getCost() {
		return ingredient.getCost();
	} // getCost()
} // AbstractIngredientDecorator()