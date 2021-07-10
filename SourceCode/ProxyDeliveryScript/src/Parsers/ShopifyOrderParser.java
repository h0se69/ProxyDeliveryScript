/*
 * https://twitter.com/h0se_69
 * Please leave me feedback or suggestions :)
 */

package Parsers;

public class ShopifyOrderParser
{
	private String dataLine;
	
	private String orderNumber;
	private String email;
	private String status;
	private String subtotal;
	private String discountCode;
	private String discountCodeAmount;
	private String itemQuantity;
	private String itemName;
	
	public ShopifyOrderParser(String dataLine) 
	{
		this.dataLine = dataLine;
		
		String[] split = dataLine.split(",");
		
		orderNumber = split[0];
		email = split[1];
		status = split[2];
		subtotal = split[8];
		discountCode = split[12];
		discountCodeAmount = split[13];
		itemQuantity = split[16];
		itemName = split[17];
	}
	
	//Getter Methods
	public String getDataLine() { return dataLine; }
	
	public String getDiscountCode() { return discountCode; }
	
	public String getDiscountCodeAmount() { return discountCodeAmount; }
	
	public String getEmail() { return email; }
	
	public String getItemName() { return itemName; }
	
	public String getItemQuantity() { return itemQuantity; }
	
	public String getOrderNumber() { return orderNumber; }
	
	public String getStatus() { return status; }
	
	public String getSubtotal() { return subtotal; }
	
	//Setter Methods
	public void setDataLine(String dataLine) { this.dataLine = dataLine; }

	public void setDiscountCode(String discountCode) { this.discountCode = discountCode; }

	public void setDiscountCodeAmount(String discountCodeAmount) { this.discountCodeAmount = discountCodeAmount; }

	public void setEmail(String email) { this.email = email; }

	public void setItemName(String itemName) { this.itemName = itemName; }

	public void setItemQuantity(String itemQuantity) { this.itemQuantity = itemQuantity; }

	public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }

	public void setStatus(String status) { this.status = status; }

	public void setSubtotal(String subtotal) { this.subtotal = subtotal; }
	
	//toString Method
	public String toString()
	{
		return "\nOrder " + orderNumber + " delivered to " + email + " | (" + itemName + ") x " + itemQuantity + "($" + subtotal + ")";
	}
}