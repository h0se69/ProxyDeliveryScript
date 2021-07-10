/*
 * https://twitter.com/h0se_69
 * Please leave me feedback or suggestions :)
 */

package Main;

import java.io.*;
import java.util.*;
import FileReaders.ShopifyOrderReader_CSV;
import Parsers.ShopifyOrderParser;

public class OrderSummary 
{
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		ShopifyOrderReader_CSV cc = new ShopifyOrderReader_CSV();
		cc.readFile("ShopifyOrderData\\shopify_CSV_goes_here");
		orderSummary(cc.getFileInfo());
	}
	
	public static String orderSummary(ArrayList<ShopifyOrderParser> data)
	{
		double totalAmountRaised = 0;
		double totalAmountLost = 0;
		double totalAmountRefunded = 0;
		double profitMade = 0;
		
		int totalOrders = 0;
		int canceledOrders = 0;
		int totalProxiesOrdered = 0;

		for(ShopifyOrderParser temp : data)
		{
			totalOrders++;

			if(temp.getStatus().contains("refunded"))
			{
				canceledOrders++;
				totalAmountRefunded += Double.parseDouble(temp.getSubtotal());
				totalAmountRaised -= Double.parseDouble(temp.getSubtotal());
				totalAmountLost -= Double.parseDouble(temp.getDiscountCodeAmount());
				totalProxiesOrdered -= Integer.parseInt(temp.getItemName().replaceAll("[^\\d]", ""));
			}
			
			totalAmountRaised += Double.parseDouble(temp.getSubtotal());
			totalAmountLost += Double.parseDouble(temp.getDiscountCodeAmount());
			totalProxiesOrdered += Integer.parseInt(temp.getItemName().replaceAll("[^\\d]", ""));

		}
		profitMade = totalAmountRaised - totalAmountLost;
		
		PrintStream orderSummaryInfo = System.out.printf("\ntotalProxiesOrdered: %s \ntotalAmountRaised: %.2f \ntotalAmountLost: %.2f \ntotalAmountRefunded: %.2f \nprofitMade: %.2f \ntotalOrders: %s \ncanceledOrders: %s"
				,totalProxiesOrdered,totalAmountRaised,totalAmountLost,totalAmountRefunded,profitMade,totalOrders,canceledOrders);
		String ordersss = orderSummaryInfo.toString();
		
		return ordersss;
	}
}
