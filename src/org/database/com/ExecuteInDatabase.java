package org.database.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.util.com.FetchData;


public class ExecuteInDatabase {
	
	
	
	public static ResultSet executeit(String q) throws Exception {
		System.out.println("Going to execute the query"+q);
		
		System.out.println("Details of conf:"+FetchData.db_driver+"ip:"+FetchData.db_ip+"Port:"+FetchData.db_port+"DB database:"+FetchData.db_name+"Db user:"+FetchData.db_user+"password:"+FetchData.db_pass);
		
		Class.forName(FetchData.db_driver);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://"+FetchData.db_ip+":"+FetchData.db_port+"/"+FetchData.db_name+"?", FetchData.db_user, FetchData.db_pass);
		//Connection con = DriverManager.getConnection("jdbc:mysql://192.168.40.2:3306/borr?", "root", "root");
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(q);
		System.out.println("query was executed");
		return rs;
	}
	
	
	public static int insertRecord(String q) throws Exception {
       System.out.println("Going to execute the query"+q);
       System.out.println("Details of conf:"+FetchData.db_driver+"ip:"+FetchData.db_ip+"Port:"+FetchData.db_port+"DB database:"+FetchData.db_name+"Db user:"+FetchData.db_user+"password:"+FetchData.db_pass);
		
		
       Class.forName(FetchData.db_driver);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://"+FetchData.db_ip+":"+FetchData.db_port+"/"+FetchData.db_name+"?", FetchData.db_user, FetchData.db_pass);
		
		Statement st = con.createStatement();
		
		int rs = st.executeUpdate(q);
		
		System.out.println("query was executed");
		return rs;
	}
	
	
	
}
