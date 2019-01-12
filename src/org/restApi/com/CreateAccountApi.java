package org.restApi.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.database.com.ExecuteInDatabase;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import com.mysql.cj.xdevapi.JsonParser;

/**
 * Servlet implementation class CreateAccountApi
 */
@WebServlet("/api/create")
public class CreateAccountApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuffer sf = new StringBuffer();
		String line = null;
		try {
			BufferedReader br = request.getReader();
			while((line = br.readLine()) != null) {
				sf.append(line);
			}	
		}catch(Exception e) {
			System.out.println("error in catch");
		}
		String data = sf.toString();
		JSONParser parser = new JSONParser();
		String name = null, adhar_no = null, mobile_no = null;
	try {
			JSONObject json = (JSONObject) parser.parse(data);
			name = json.get("name").toString();
			adhar_no = json.get("aadhar").toString();
			mobile_no = json.get("mobile").toString();
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
		
		
		String header_nm = request.getHeader("process");
		
		
		System.out.println("Header Process:"+header_nm);
		System.out.println("Name:"+name+" Aadhar no:"+adhar_no+" Mobile no:"+mobile_no);
	
		
		PrintWriter pw = response.getWriter();
		
	    if(header_nm.equalsIgnoreCase("add")) {
	    	String query = "INSERT INTO account_detail (name, aadhar_no, mobile_no) VALUES ('"+name+"', "+adhar_no+","+mobile_no+");";
			System.out.println("Query was:"+query);
			int rs= 0;
			try {
			 rs = ExecuteInDatabase.insertRecord(query);
			 System.out.println("number is :"+rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	pw.print("Your record has been added successfully");
	    }else if(header_nm.equalsIgnoreCase("update")){    //here we can update only aadhar number and mobile number
	    	String query = "UPDATE account_detail SET aadhar_no="+adhar_no+", mobile_no="+mobile_no+" WHERE name='"+name+"';";
			System.out.println("Query was:"+query);
			int rs= 0;
			try {
			 rs = ExecuteInDatabase.insertRecord(query);
			 System.out.println("number is :"+rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JSONObject rj = new JSONObject();
			rj.put("updated_aadhar", adhar_no);
			rj.put("updated_mobile", mobile_no);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(rj);
		  }else {
	    	response.setStatus(500);
	    	pw.print("Invalid header");
	    }
		
		
		
		
	}

}
