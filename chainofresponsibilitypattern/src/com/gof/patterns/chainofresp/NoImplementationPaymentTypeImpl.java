package com.gof.patterns.chainofresp;

/**
 *   File      : NoImplementationPaymentTypeImpl.java
 *   Author    : Chris Elliott
 *   Created   : 15-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   :
 */
public class NoImplementationPaymentTypeImpl extends AbstractPaymentType {
	public NoImplementationPaymentTypeImpl(final AbstractPaymentType successor) {
		super(successor);
	} // NoImplementationPaymentTypeImpl()
	
	/**
	 * @param orderReceipt
	 * @return true or false
	 */
	@Override
	public boolean hasService(final OrderReceiptImpl orderReceipt) {
		return true;
	} // hasService()

	/**
	 * @param orderReceipt
	 * @return true or false
	 */
	@Override
	public boolean process(final OrderReceiptImpl orderReceipt) {
		boolean status = false;
		if( hasService(orderReceipt) ) {
			System.out.println("Unable to collect: " + orderReceipt.getAmount());
			System.out.println("Invalid method:    " + orderReceipt.getEnumeratedPaymentType());
		} // if
		// Return
		return status;
	} // process()
} // NoImplementationPaymentTypeImpl()