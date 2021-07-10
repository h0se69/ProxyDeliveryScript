/*
 * https://twitter.com/h0se_69
 * Please leave me feedback or suggestions :)
 */

package FileReaders;

import java.io.*;
import java.util.*;

public class ProxyFileReader 
{
	
	private BufferedReader br = null;
	private ArrayList<String> proxyInfo = null;

	public void readFile(String fileName)
	{
		String line;
		try
		{
			br = new BufferedReader(new FileReader(fileName));
			proxyInfo = new ArrayList<>();
			br.readLine();
			while((line = br.readLine()) != null) { proxyInfo.add(line); }
		}
		catch (Exception e) { System.out.println("Could not read proxy file"); }
	}
}
