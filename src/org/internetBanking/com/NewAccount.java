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
 * Servlet implementation class NewAccount
 */
@WebServlet(description = "For adding new account in this bank", urlPatterns = { "/addnewacc" })
public class NewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nm");
	    String date = request.getParameter("dob");
	    String aadth_no = request.getParameter("adh_no");
	    String mob_no = request.getParameter("mob_no");
	    System.out.println("Name:"+name+" Date:"+date+"Aadhar no:"+aadth_no+" Mobile:"+mob_no);
	    
	    String qry = "SELECT * FROM account_detail WHERE mobile_no='"+mob_no+"' OR aadhar_no='"+aadth_no+"';";
		System.out.println("Query was:"+qry);
		try {
			ResultSet qq = ExecuteInDatabase.executeit(qry);
			if(qq.next()) {
				System.out.println("Given the same aadhar number or moible number");
				PrintWriter p = response.getWriter();
				p.println("<p style=\"color:blue;font-size:30px;\">Mobile number or aadhar number already exists. Give some other</p>");
				RequestDispatcher ds = request.getRequestDispatcher("jsp/createAccount.jsp");
				ds.include(request, response);
				return;
			}else {
				System.out.println("No other record in the same mobile and the aadhar number");
				RequestDispatcher ds = request.getRequestDispatcher("jsp/create_acc_confirm.jsp");
				ds.forward(request, response);
				return;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
	}

}
