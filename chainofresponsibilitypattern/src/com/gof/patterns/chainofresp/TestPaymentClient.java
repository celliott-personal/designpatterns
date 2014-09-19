package com.gof.patterns.chainofresp;

/**
 *   File      : TestPaymentClient.java
 *   Author    : Chris Elliott
 *   Created   : 15-Sept-2014
 *   Revision  : Initial Revision
 *
 *   History   : The <code>TestPaymentClient</code> acts as the payment type request
 *               broker.
 *               
 *               The client maintains a reference to a given receipt and then passes
 *               the request through the chain using an abstract payment type handler.
 *               
 *               During this process, the client does not need to know what type of 
 *               handler is able to pick up the request, so the chain refers only to
 *               the abstract base types and then eventually, a specific type will 
 *               return a status, or an exit of false if the default payment type is
 *               used.
 */
public class TestPaymentClient {
	public static void main(String[] args) {
		/*
		 * Establish the chain of responsibility using constructors so that 
		 * immutability can be achieved.
		 * 
		 * The default no implementation type is the last handler referenced
		 * because we need a catch all scenario to be managed as well.  In fact,
		 * this is one of the design problems a developer faces with this pattern, 
		 * because if the sequence is not planned, requests could easily be missed
		 * managed and lost.
		 */
		AbstractPaymentType handler = new CashPaymentTypeImpl(new CreditCardPaymentTypeImpl(new VoucherPaymentTypeImpl(new PointsPaymentTypeImpl(new NoImplementationPaymentTypeImpl(null)))));
		
		/*
		 * Create a failure situation and then process the request through the 
		 * abstract chain.
		 */
		System.out.println("Customer want's to pay by cheque, good luck with that!");
		OrderReceiptImpl receipt = new OrderReceiptImpl(4.56, EnumeratedPaymentType.CHEQUE);
		if( ! handler.process(receipt) ) {
			System.out.println("Selecting Credit Card...");
			receipt = new OrderReceiptImpl(4.56, EnumeratedPaymentType.CREDITCARD);
			handler.process(receipt);
		} // if
		
		/*
		 * Create an accept voucher type of request and then process the request
		 * through the chain.
		 */
		System.out.println("Customer want's to pay by voucher!");
		receipt = new OrderReceiptImpl(8.99, EnumeratedPaymentType.VOUCHER);
		if( ! handler.process(receipt) ) {
			System.out.println("Customer has left in haste!");
		} // if
		
		/*
		 * Create an accept points type of request and then process the request
		 * through the chain.
		 */
		System.out.println("Customer want's to pay by loyalty points!");
		receipt = new OrderReceiptImpl(14.13, EnumeratedPaymentType.LOYALTYPOINTS);
		if( ! handler.process(receipt) ) {
			System.out.println("Customer is refusing to pay!");
		} // if
		
		/*
		 * Create an accept points type of request and then process the request
		 * through the chain.
		 */
		System.out.println("Customer want's to pay by doing the dishes!");
		receipt = new OrderReceiptImpl(32.60, EnumeratedPaymentType.DISHWASHERFORDAY);
		if( ! handler.process(receipt) ) {
			System.out.println("Selecting cheque...");
			receipt = new OrderReceiptImpl(32.60, EnumeratedPaymentType.CHEQUE);
			if( ! handler.process(receipt) ) {
				System.out.println("Selecting credit card...");
				receipt = new OrderReceiptImpl(32.60, EnumeratedPaymentType.CREDITCARD);
				if( ! handler.process(receipt) ) {
					System.out.println("Customer does a bunk!");
				} // if
			} // if
		} // if
	} // main()
} // TestPaymentClient()