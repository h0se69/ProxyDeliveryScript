/*
 * https://twitter.com/h0se_69
 * Please leave me feedback or suggestions :)
 */
package Main;

import java.io.IOException;
import java.util.*;

public class ScriptRunner 
{
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Proxy Delivery Script by @h0se_69 :)");
		System.out.println("1) Order Summary");
		System.out.println("2) Deliver Proxies");
		System.out.println("3) Close Script");
		System.out.print("Option: ");
		String option = in.next();
		in.close();
		
		if(option.equals("1")) { new OrderSummary().main(args); }
		else if(option.equals("2")) { new ProxyDelivery().main(args); }
		else if(option.equals("3")) { System.out.println("Closing Script..."); System.exit(2000); }
		else { System.out.println("Invalid Option lol"); }
	}
}
