package com.gof.patterns.decorator;

import java.math.BigDecimal;

/**
 *   File      : CheeseDecoratorImpl.java
 *   Author    : Chris Elliott
 *   Created   : 14-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   : 
 */
public class CheeseDecoratorImpl extends AbstractIngredientDecorator {
	public CheeseDecoratorImpl(final Ingredient ingredient) {
		super(ingredient);
	} // CheeseDecoratorImpl()
	
	/**
	 * @return wrapped name with added text
	 */
	@Override
	public String getItemName() {
		return super.getItemName() + " with cheese";
	} // getItemName()
	
	/**
	 * @return wrapped cost with added price
	 */
	@Override
	public BigDecimal getCost() {
		System.out.println("Adding 0.56 to the cost");
		return super.getCost().add(new BigDecimal(0.56).setScale(2, BigDecimal.ROUND_HALF_UP));
	} // getCost()
} // CheeseDecoratorImpl()