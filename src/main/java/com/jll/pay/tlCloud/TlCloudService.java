package com.jll.pay.tlCloud;

import java.util.Map;

public interface TlCloudService
{
	  /**
	   * if the remote client is authorized, it means if the ip locates in white list
	 * @param ip the remote client ip
	 * @return
	 */
	boolean isAuthorized(String ip);
  
	  /**
	   * process the order that the money already in bank account.
	 * @param orderId
	 * @return
	 */
	String receiveDepositOrder(int orderId);
	
	/**
	 * checking if the specified order is existing in database
	 * @param orderId
	 * @return
	 */
	boolean isOrderExisting(int orderId);
	
	/**
	 * sending the PlaceOrder request to tonglue cloud 
	 * @param response
	 * @return if success
	 */
	String saveDepositOrder(Map<String, Object> params);
	
	String cancelOrder(int orderId);
}
