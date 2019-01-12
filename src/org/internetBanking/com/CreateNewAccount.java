package org.internetBanking.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.database.com.ExecuteInDatabase;
import org.database.com.GetDetails;

/**
 * Servlet implementation class CreateNewAccount
 */
@WebServlet(description = "Used to create the account", urlPatterns = { "/create_accont_confirm" })
public class CreateNewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String mobile = request.getParameter("mob");
		String aadhar = request.getParameter("adh");
		String dob = request.getParameter("dob");
		String id = request.getParameter("usd");
		String ps = request.getParameter("passw");
		String psc = request.getParameter("passcon");
		int acc_no=0;
		String ifsc_code = "MYBK008011";
		if(ps.equals(psc)) {
		System.out.println("both password matches. going to insert the record");
		
		try {
			 acc_no = GetDetails.getNewAccountNo(ifsc_code);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String query = "INSERT INTO account_detail (account_no, name, pin, user_id, aadhar_no, mobile_no, dob, ifsc) VALUES ("+acc_no+",'"+name+"', '"+ps+"', '"+id+"', "+aadhar+","+mobile+", '"+dob+"','"+ifsc_code+"');";
		System.out.println("Query was:"+query);
		int rs= 0;
		try {
		 rs = ExecuteInDatabase.insertRecord(query);
		 System.out.println("number is :"+rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs == 1) {
		RequestDispatcher dsp = request.getRequestDispatcher("jsp/succ_home.jsp");
		dsp.include(request, response);
		return;
		}
		else {
		System.out.println("number is not zero");	
		}
		} else {
		System.out.println("Both password as incorred password is:"+ps+"confirm is password:"+psc);
		PrintWriter pw = response.getWriter();
		pw.println("<p style=\"color:red;font-size:30px;\">password not match. give correct password</p>");
		RequestDispatcher dsp = request.getRequestDispatcher("jsp/create_acc_confirm.jsp");
		dsp.include(request, response);	
		return;
		}
	}

}
