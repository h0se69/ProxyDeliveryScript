/*
 * https://twitter.com/h0se_69
 * Please leave me feedback or suggestions :)
 */

package FileReaders;

import java.io.*;
import java.util.*;
import Parsers.ShopifyOrderParser;

/*
 * When using this program/script we use the csv file that is provided
 * by Shopify to avoid potential errors.
 */

public class ShopifyOrderReader_CSV
{
	private BufferedReader br = null;
	private ArrayList<ShopifyOrderParser> fileInfo = null;

	public void readFile(String fileName)
	{
		String line;
		try
		{
			br = new BufferedReader(new FileReader(fileName));
			fileInfo = new ArrayList<>();
			br.readLine();
			
			while((line = br.readLine()) != null)
			{
				ShopifyOrderParser parsedInfo = new ShopifyOrderParser(line);
				fileInfo.add(parsedInfo);
			}
		}
		catch (Exception e) { System.out.println("Could not read order file"); }
	}
	
	public ArrayList<ShopifyOrderParser> getFileInfo() { return fileInfo; }
}
