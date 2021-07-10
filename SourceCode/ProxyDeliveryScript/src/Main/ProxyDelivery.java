/*
 * https://twitter.com/h0se_69
 * Please leave me feedback or suggestions :)
 */
package Main;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import FileReaders.ShopifyOrderReader_CSV;
import MailSetup.GmailSetup;
import Parsers.ShopifyOrderParser;

public class ProxyDelivery 
{	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		ShopifyOrderReader_CSV cc = new ShopifyOrderReader_CSV();
		cc.readFile("ShopifyOrderData\\shopify_CSV_goes_here");
		deliverProxies(cc.getFileInfo());
	}
	
	public static String deliverProxies(ArrayList<ShopifyOrderParser> data) throws InterruptedException, IOException
	{
		int delay = 4500;
		int y = 1;
		ArrayList<String> proxyList = new ArrayList<String>();
		int value = 1;
		String filteredProxyList;
		

		for(ShopifyOrderParser temp : data)
		{
			int proxyStart = 0;
			int proxyEnd = 0;
			
			if(temp.getStatus().contains("refunded"))
			{
				System.out.println("\nSkipping Refunded Order!"); 
			}
			else
			{
				proxyList.clear();
				proxyStart += value;
				value += Integer.parseInt(temp.getItemName().replaceAll("[^\\d]", ""));
				for(int i = y - 1; i < value - 1; i++)
				{
					String line = Files.readAllLines(Paths.get("ProxyList\\Proxies_Go_Here_1_Line_at_a_time")).get(i);
					proxyList.add("\n" + line);
				}
				y += Integer.parseInt(temp.getItemName().replaceAll("[^\\d]", ""));
				proxyEnd += y;
				filteredProxyList = proxyList.toString().replace("[", "").replace("]", "").replace(",", "").trim();
				
				String email = Files.readAllLines(Paths.get("LoginInformation\\Gmail_Login_Info")).get(0);
				String password = Files.readAllLines(Paths.get("LoginInformation\\Gmail_Login_Info")).get(1);
				String discordInvite = Files.readAllLines(Paths.get("ProxyList\\Discord_Invite_goes_here")).get(0);

				GmailSetup.send(temp.getEmail(), email, password, "Your proxy order " + temp.getOrderNumber() + " has arrived!", filteredProxyList + ("\n" + discordInvite));
				
				System.out.println("Order " + temp.getOrderNumber() + " delivered to " + temp.getEmail() + " | (" + temp.getItemName() + ") x " + temp.getItemQuantity() + " | ($"+temp.getSubtotal()+")" + " | (Proxies " + proxyStart + "-" + (proxyEnd - 1) + ")");
				
				System.out.println("Sleeping for " + delay + "ms");
				Thread.sleep(delay);
			}
		}
		System.out.println("All orders have been delivered!");
		return null;
	}
}
