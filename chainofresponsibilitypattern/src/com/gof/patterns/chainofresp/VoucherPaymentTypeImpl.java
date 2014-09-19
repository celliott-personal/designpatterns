package com.gof.patterns.chainofresp;

/**
 *   File      : VoucherPaymentTypeImpl.java
 *   Author    : Chris Elliott
 *   Created   : 15-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   :
 */
public class VoucherPaymentTypeImpl extends AbstractPaymentType {
	public VoucherPaymentTypeImpl(final AbstractPaymentType successor) {
		super(successor);
	} // VoucherPaymentTypeImpl()
	
	/**
	 * @param orderReceipt
	 * @return true or false
	 */
	@Override
	public boolean hasService(final OrderReceiptImpl orderReceipt) {
		return (orderReceipt.getEnumeratedPaymentType() == EnumeratedPaymentType.VOUCHER);
	} // hasService()

	/**
	 * @param orderReceipt
	 * @return true or false
	 */
	@Override
	public boolean process(final OrderReceiptImpl orderReceipt) {
		boolean status = true;
		if( hasService(orderReceipt) ) {
			System.out.println("Voucher handler for: " + orderReceipt.getAmount());
		} else {
			// Allow the request to go through the chain
			status = pass(orderReceipt);
		} // if..else
		// Return
		return status;
	} // process()
} // VoucherPaymentTypeImpl()