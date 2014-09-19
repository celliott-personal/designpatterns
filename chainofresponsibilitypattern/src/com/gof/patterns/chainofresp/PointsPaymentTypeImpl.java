package com.gof.patterns.chainofresp;

/**
 *   File      : PointsPaymentTypeImpl.java
 *   Author    : Chris Elliott
 *   Created   : 15-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   :
 */
public class PointsPaymentTypeImpl extends AbstractPaymentType {
	public PointsPaymentTypeImpl(final AbstractPaymentType successor) {
		super(successor);
	} // PointsPaymentTypeImpl()
	
	/**
	 * @param orderReceipt
	 * @return true or false
	 */
	@Override
	public boolean hasService(final OrderReceiptImpl orderReceipt) {
		return (orderReceipt.getEnumeratedPaymentType() == EnumeratedPaymentType.LOYALTYPOINTS);
	} // hasService()

	/**
	 * @param orderReceipt
	 * @return true or false
	 */
	@Override
	public boolean process(final OrderReceiptImpl orderReceipt) {
		boolean status = true;
		if( hasService(orderReceipt) ) {
			System.out.println("Loyalty points handler for: " + orderReceipt.getAmount());
		} else {
			status = pass(orderReceipt);
		} // if..else
		// Return
		return status;
	} // process()
} // PointsPaymentTypeImpl()