package org.util.com;

import java.io.BufferedReader;
import java.io.FileReader;

public class FetchData {

	static String path = "C:\\Users\\dsr\\eclipse-workspace\\RNetBanking\\conf\\conf.properties";
	
	public static String db_driver = giveValue(path, "com.rnetbanking.mysql.driver");
	public static String db_ip = giveValue(path, "com.rnetbanking.mysql.ip");
	public static String db_port = giveValue(path, "com.rnetbanking.mysql.port");
	public static String db_name = giveValue(path, "com.rnetbanking.mysql.db.name");
	public static String db_user = giveValue(path, "com.rnetbanking.mysql.username");
	public static String db_pass = giveValue(path, "com.rnetbanking.mysql.password");
	public static String api_allowed = giveValue(path, "com.rnetbanking.api.ip.allowed");
	
	/*
	public static String Api_ip() {
		
		System.out.println("ooo");
		 try {
			a= giveValue(path, "com.thirdparty.api.ip");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}*/
	
	
	
	public static String giveValue(String path, String sc) {
		String value=null;
		try {
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while((line = br.readLine()) != null){
			
		//System.out.println("string is:"+line);
			if(line.startsWith(sc+"=")) {
				value=line.substring(sc.length()+1);    //1 is for equal to "="
			}
		}
		
		br.close();}catch(Exception e) {
			
		}
		return value;
	}
	
}
