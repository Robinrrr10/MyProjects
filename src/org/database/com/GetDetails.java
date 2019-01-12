package org.database.com;

import java.sql.ResultSet;

public class GetDetails {

	public static int getNewAccountNo(String ifsc) throws Exception{
		int mxacc = 0;
		String query = "SELECT MAX(account_no) FROM account_detail WHERE ifsc='"+ifsc+"';";
		ResultSet rs = ExecuteInDatabase.executeit(query);
		while(rs.next()) {
			mxacc = rs.getInt(1);
		}
		
	  int newAcc = mxacc + 1;
		
		return newAcc;
	}
	
	
	
	
}
