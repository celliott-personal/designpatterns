package com.gof.patterns.decorator;

import java.math.BigDecimal;

/**
 *   File      : Ingredient.java
 *   Author    : Chris Elliott
 *   Created   : 14-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   :
 */
public interface Ingredient {
	public String getItemName();
	public BigDecimal getCost();
} // Ingredient()