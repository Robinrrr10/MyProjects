package org.internetBanking.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.database.com.ExecuteInDatabase;

/**
 * Servlet implementation class GoLogin
 */
@WebServlet(description = "LoginCheckPage", urlPatterns = { "/intbank" })
public class GoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		System.out.println("Do Login page -> doGet");
		String user = request.getParameter("id");
		String pass = request.getParameter("ps");
		System.out.println("Given user id["+user+"] and password["+pass+"]");
		String qry = "SELECT name, pin from account_detail where user_id='"+user+"' and pin='"+pass+"';";
		System.out.println("Query was:"+qry);
		try {
			ResultSet qq = ExecuteInDatabase.executeit(qry);
			if(qq.next()) {
				System.out.println("Login successful");
				//response.sendRedirect("jsp/succ_home.jsp");
				RequestDispatcher ds = request.getRequestDispatcher("jsp/succ_home.jsp");
				ds.forward(request, response);
				return;
			}else {
				System.out.println("Login credential Incorrect");
				PrintWriter p = response.getWriter();
				p.println("<p style=\"color:blue;font-size:30px;\">Invalid password</p>");
				//response.sendRedirect("signin");
				RequestDispatcher ds = request.getRequestDispatcher("signin");
				ds.include(request, response);
				return;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	

}
