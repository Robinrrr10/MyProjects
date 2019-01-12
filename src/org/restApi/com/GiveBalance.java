package org.restApi.com;

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
 * Servlet implementation class GiveBalance
 */
@WebServlet(description = "Used to send balance to the user", urlPatterns = { "/checkBalance" })
public class GiveBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("RNetBanking API");
		
		String acc_no = request.getParameter("account_no");
		String dob = request.getParameter("date_of_birth");
		System.out.println("Given Account no:"+acc_no+" Date of Birth:"+dob);
		
		if(acc_no != null && dob !=null) {
			System.out.println("Given Account no:"+acc_no+" Date of Birth:"+dob);
			String qry = "SELECT balance FROM account_detail WHERE account_no='"+acc_no+"' AND dob='"+dob+"'"; 
			
			PrintWriter pw = response.getWriter();
			
			try {
				ResultSet rs = ExecuteInDatabase.executeit(qry);
				String a = null;
				if(rs.next()) {
					a = rs.getString(1);
					
					System.out.println("Balance was:"+a);
					pw.print(a);
					
				}else {
					
				System.out.println("Balance was:"+a);
				pw.print("Give correct account_no and date of birth");
				}
			} catch (Exception e) {
				System.out.println("Error in Executing the query");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else {
			System.out.println("Given Account no:"+acc_no+" Date of Birth:"+dob);
			
			System.out.println("Mandatory parameter was missing. Check whether account no and date of birth are given are not");
			
		}
		
		
		
	}

}
