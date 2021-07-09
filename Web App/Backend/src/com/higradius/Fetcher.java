package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class Fetcher
 */
@WebServlet("/Fetcher")
public class Fetcher extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/H2HMIKE1529";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fetcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection conn = null;
		Statement stmt = null;
		List<Response> DataList = new ArrayList<>();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql;
			String page = request.getParameter("page");
			
			if(page==null || Integer.parseInt(page)<1 ) {
				page="1";
			} 
			int pagecnt = Integer.parseInt(page);
			int offset = (pagecnt-1)*10;
			String offsetstr = Integer.toString(offset);
			sql = "SELECT name_customer,cust_number, doc_id,total_open_amount,due_in_date,predicted_payment_date,notes FROM mytable ORDER BY FIELD1 LIMIT 10 OFFSET ";
			sql = sql.concat(offsetstr);
			
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				Response fetch = new Response();
				fetch.setCustName(rs.getString("name_customer"));
				fetch.setCustNo(rs.getString("cust_number"));
				fetch.setInvoiceID(rs.getString("doc_id"));
				fetch.setInvoiceAmount(rs.getString("total_open_amount"));
				fetch.setDueDate(rs.getString("due_in_date"));
				fetch.setPredPayDate(rs.getString("predicted_payment_date"));
				fetch.setNotes(rs.getString("notes"));
				DataList.add(fetch);
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(DataList);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			try {
			 response.getWriter().write(json);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

			//Closing all the connections
			rs.close();
			stmt.close();
			conn.close();
			}catch(SQLException se){
			//Handle errors for JDBC
				se.printStackTrace();
			}catch(Exception e){
			//Handle errors for Class.forName
				e.printStackTrace();
			}finally{
				//finally block used to close resources
				try{
				if(stmt!=null)
				stmt.close();
				}catch(SQLException se2){
				}
				try{
					if(conn!=null)
						conn.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
}
