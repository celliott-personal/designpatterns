package com.gof.patterns.decorator;

import java.math.BigDecimal;

/**
 *   File      : TunaDecoratorImpl.java
 *   Author    : Chris Elliott
 *   Created   : 14-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   : 
 */
public class TunaDecoratorImpl extends AbstractIngredientDecorator {
	public TunaDecoratorImpl(final Ingredient ingredient) {
		super(ingredient);
	} // TunaDecoratorImpl()
	
	/**
	 * @return wrapped name with added text
	 */
	@Override
	public String getItemName() {
		return super.getItemName() + " with tuna";
	} // getItemName()
	
	/**
	 * @return wrapped cost with added price
	 */
	@Override
	public BigDecimal getCost() {
		System.out.println("Adding 1.80 to the cost");
		return super.getCost().add(new BigDecimal(1.80).setScale(2, BigDecimal.ROUND_HALF_UP));
	} // getCost()
} // TunaDecoratorImpl()