package com.gof.patterns.chainofresp;

/**
 *   File      : AbstractPaymentType.java
 *   Author    : Chris Elliott
 *   Created   : 15-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   : The <code>AbstractPaymentType</code> abstract class provides
 *               a skeleton implementation that maintains a link between all
 *               known request handlers able to perform a task on a given 
 *               <code>OrderReceiptImpl</code> instance.
 */
public abstract class AbstractPaymentType {
	private final AbstractPaymentType successor;
	
	public AbstractPaymentType(final AbstractPaymentType successor) {
		this.successor = successor;
	} // AbstractPaymentType()
	
	/**
	 * @return true or false
	 */
	protected boolean hasSuccessor() {
		return (successor != null);
	} // hasSuccessor()
	
	/**
	 * The <code>pass</code> method acts as a bridge to the successor instance
	 * so that other handlers can try to execute a task on a given request.
	 * 
	 * @param orderReceipt
	 * @return true or false
	 */
	protected boolean pass(final OrderReceiptImpl orderReceipt) {
		boolean status = false;
		if( hasSuccessor() ) {
			// Pass message or request through to the next handler
			System.out.println("Passing request through...");
			status = successor.process(orderReceipt);
		} // if
		// Return
		return status;
	} // pass()
	
	/**
	 * @param orderReceipt
	 * @return true or false
	 */
	public abstract boolean hasService(OrderReceiptImpl orderReceipt);
	
	/**
	 * @param orderReceipt
	 * @return true or false
	 */
	public abstract boolean process(OrderReceiptImpl orderReceipt);
} // AbstractPaymentType()