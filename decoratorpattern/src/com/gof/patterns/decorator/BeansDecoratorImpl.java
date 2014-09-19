package com.gof.patterns.decorator;

import java.math.BigDecimal;

/**
 *   File      : BeansDecoratorImpl.java
 *   Author    : Chris Elliott
 *   Created   : 14-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   : 
 */
public class BeansDecoratorImpl extends AbstractIngredientDecorator {
	public BeansDecoratorImpl(final Ingredient ingredient) {
		super(ingredient);
	} // BeansDecoratorImpl()
	
	/**
	 * @return wrapped name with added text
	 */
	@Override
	public String getItemName() {
		return super.getItemName() + " with baked beans";
	} // getItemName()
	
	/**
	 * @return wrapped cost with added price
	 */
	@Override
	public BigDecimal getCost() {
		System.out.println("Adding 0.85 to the cost");
		return super.getCost().add(new BigDecimal(0.85).setScale(2, BigDecimal.ROUND_HALF_UP));
	} // getCost()
} // BeansDecorator()