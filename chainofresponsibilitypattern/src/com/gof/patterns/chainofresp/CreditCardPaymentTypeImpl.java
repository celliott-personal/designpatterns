package com.gof.patterns.chainofresp;

/**
 *   File      : CreditCardPaymentTypeImpl.java
 *   Author    : Chris Elliott
 *   Created   : 15-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   :
 */
public final class CreditCardPaymentTypeImpl extends AbstractPaymentType {
	public CreditCardPaymentTypeImpl(final AbstractPaymentType successor) {
		super(successor);
	} // CreditCardPaymentTypeImpl()
	
	/**
	 * @param orderReceipt
	 * @return true or false
	 */
	@Override
	public boolean hasService(final OrderReceiptImpl orderReceipt) {
		return (orderReceipt.getEnumeratedPaymentType() == EnumeratedPaymentType.CREDITCARD);
	} // hasService()

	/**
	 * @param orderReceipt
	 * @return true or false
	 */
	@Override
	public boolean process(final OrderReceiptImpl orderReceipt) {
		boolean status = true;
		if( hasService(orderReceipt) ) {
			System.out.println("Card handler for: " + orderReceipt.getAmount());
		} else {
			// Allow the request to go through the chain
			status = pass(orderReceipt);
		} // if..else
		// Return
		return status;
	} // process()
} // CreditCardPaymentTypeImpl()