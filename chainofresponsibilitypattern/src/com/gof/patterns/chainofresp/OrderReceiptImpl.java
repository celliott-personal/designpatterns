package com.gof.patterns.chainofresp;

/**
 *   File      : OrderReceiptImpl.java
 *   Author    : Chris Elliott
 *   Created   : 15-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   : The <code>OrderReceiptImpl</code> provides a basic template for a 
 *               request that is able to be picked up by a given payment request
 *               handler.
 */   
public class OrderReceiptImpl {
	private final double                amount;
	private final EnumeratedPaymentType enumeratedPaymentType;
	
	public OrderReceiptImpl(final double amount, final EnumeratedPaymentType enumeratedPaymentType) {
		this.amount                = amount;
		this.enumeratedPaymentType = enumeratedPaymentType;
	} // OrderReceiptImpl()

	/**
	 * @return amount
	 */
	public double getAmount() {
		return amount;
	} // getAmount()

	/**
	 * @return enumeratedPaymentType
	 */
	public EnumeratedPaymentType getEnumeratedPaymentType() {
		return enumeratedPaymentType;
	} // getEnumeratedPaymentType()
} // OrderReceiptImpl()