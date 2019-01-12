package org.mobileApp.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.database.com.ExecuteInDatabase;

/**
 * Servlet implementation class MobileLogin
 */
@WebServlet(urlPatterns = { "/MloginPage" })
public class MobileLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("mobile do post");
		
		System.out.println("Mobile->Before return:");
		PrintWriter pw = response.getWriter();
		pw.println("robin");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Mobile Login - Now in Post method");
		String email = request.getParameter("em");
		String password = request.getParameter("ps");
		System.out.println("Mobile->Email:"+email+" Password:"+password);
		
		String query = "SELECT name, pin from account_detail where email='"+email+"' and pin='"+password+"';";
		
		System.out.println("Query:"+query);
		String rll = null;
		try {
			ResultSet rs = ExecuteInDatabase.executeit(query);
			if(rs.next()) {
				System.out.println("Mobile->Successfully logged In");
				rll = rs.getString(1);
				System.out.println("Mobile->Got the query result:"+rll);
			}else {
				System.out.println("Mobile->Login Not successfull");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Mobile->Before return:"+rll);
		PrintWriter pw = response.getWriter();
		pw.println(rll);
		
	}

}
