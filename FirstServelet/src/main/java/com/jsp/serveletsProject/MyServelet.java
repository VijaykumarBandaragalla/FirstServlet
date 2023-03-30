package com.jsp.serveletsProject;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServelet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		String firstName=req.getParameter("fnm");
		String lastName=req.getParameter("lnm");
		String email=req.getParameter("em");
		String phone =req.getParameter("ph");
		String adress=req.getParameter("add");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='orange'><h1>" +
		"conrgrats your data is recorded Sucessfully "+firstName +"</h1></body></html>");
		out.flush();
		
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt = con.prepareStatement("insert into girmiti.servlets values(?,?,?,?,?)");
			pstmt.setString(1, firstName);
			pstmt.setString(2,lastName);
			pstmt.setString(3,email);
			pstmt.setString(4,phone);
			pstmt.setString(5,adress);
			pstmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
