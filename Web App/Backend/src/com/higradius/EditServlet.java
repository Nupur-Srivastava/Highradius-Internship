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



@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 3L;
	static final String dbDriver="com.mysql.jdbc.Driver";
	static final String dbURL="jdbc:mysql://localhost:3306/";
	static final String dbname="H2HMIKE1529";
	static final String username="root";
	static final String password="root";
   
    public EditServlet() {
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
			String amt = request.getParameter("amt");
			String notes = request.getParameter("notes");
			PreparedStatement ps = con.prepareStatement("UPDATE mytable SET total_open_amount=\""+amt+"\",notes=\""+notes+"\" WHERE doc_id=\""+invoice+"\"");
			System.out.println(ps);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().write("UPDATED");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}