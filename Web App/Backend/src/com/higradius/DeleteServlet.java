package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;
	static final String dbDriver="com.mysql.jdbc.Driver";
	static final String dbURL="jdbc:mysql://localhost:3306/";
	static final String dbname="H2HBABBA1529";
	static final String username="root";
	static final String password="root";
   
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            //Connecting JDBC with SQL
			Connection con = DriverManager.getConnection(dbURL+dbname, username, password);
			//Creating an PreparedStatement to edit data into an database
			String invoice = request.getParameter("invoice");
			PreparedStatement ps = con.prepareStatement("DELETE FROM mytable WHERE doc_id=\""+invoice+"\"");
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().write("DELETED");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}