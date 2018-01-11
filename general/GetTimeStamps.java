package general;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GetTimeStamps {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String filename;
		filename = scan.nextLine();

		BufferedReader br = null;
		FileReader fr = null;
		BufferedWriter wr = null;
		Set<String> timeSet = new LinkedHashSet<String>();

		// read file
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			wr = new BufferedWriter(new FileWriter("req_" + filename));
			String line;

			while ((line = br.readLine()) != null) {
				String dateTime = line.substring(line.indexOf("[") + 1, line.indexOf("-0400") - 1);
				//wr.write(dateTime);
				if(!timeSet.contains(dateTime)) {
					timeSet.add(dateTime);
				}
			}
			
			for(String d : timeSet) {
				wr.write(d);
				wr.newLine();
			}
			
			br.close();
			fr.close();
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main1(String args[]) {
		String filename;
		filename = scan.nextLine();

		BufferedReader br = null;
		FileReader fr = null;
		BufferedWriter wr = null;
		Map<String, Integer> hostsMap = new LinkedHashMap<String, Integer>();

		// read file
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			wr = new BufferedWriter(new FileWriter("records_" + filename));
			String line;

			while ((line = br.readLine()) != null) {
				String host = line.substring(0, line.indexOf("-") - 1);
				if(hostsMap.containsKey(host)) {
					hostsMap.put(host, hostsMap.get(host) + 1);
				} else {
					hostsMap.put(host, 1);
				}
			}
			
			for(String key : hostsMap.keySet()) {
				wr.write(key + " " + hostsMap.get(key));
				wr.newLine();
			}
			
			br.close();
			fr.close();
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
