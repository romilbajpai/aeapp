package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {

		  private String message;
		  
		  // JDBC driver name and database URL
		   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://127.4.221.130:3306/romil";

		   //  Database credentials
		   static final String USER = "adminMGMw1CR";
		   static final String PASS = "ptV1huB54d7C";


		  public void init() throws ServletException
		  {
		      // Do required initialization
		      message = "Hello World";
		  }

		  public void doGet(HttpServletRequest request,
		                    HttpServletResponse response)
		            throws ServletException, IOException
		  {
			  Connection conn = null;
			  Statement stmt = null;

			  try
			  {
				  Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();

			      String sql;
			      sql = "select POLICY_NUMBER from PRIME_POLICY_CUSTOMER_HISTORY";
			      ResultSet rs = stmt.executeQuery(sql);

			      
			      // Set response content type
			      response.setContentType("text/html");

			      // Actual logic goes here.
			      PrintWriter out = response.getWriter();
			      out.println("<h1>" + message + "</h1>");  
			  }
			  catch(Exception e)
			  {
				  
			  }
			  
		  }
		  
		  public void destroy()
		  {
		      // do nothing.
		  }
		}
