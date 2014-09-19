package com.gof.patterns.decorator;

import java.math.BigDecimal;

/**
 *   File      : WhiteBreadSandwichImpl.java
 *   Author    : Chris Elliott
 *   Created   : 14-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   : The <code>WhiteBreadSandwichImpl</code> class provides the final
 *               implementation as a base type of <code>Ingredient</code>.
 *               
 *               An object of this class can be extended at runtime, by using any
 *               number of the decorator implementations.
 */
public class WhiteBreadSandwichImpl implements Ingredient {
	/**
	 * @return itemName
	 */
	@Override
	public String getItemName() {
		return "Thick Sliced Sandwich (on white)";
	} // getItemName()
	
	/**
	 * @return cost
	 */
	@Override
	public BigDecimal getCost() {
		return new BigDecimal(1.25).setScale(2, BigDecimal.ROUND_HALF_UP);
	} // getCost()
} // WhiteBreadSandwichImpl()