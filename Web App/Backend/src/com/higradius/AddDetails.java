package com.higradius;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddDetails
 */
@WebServlet("/AddDetails")
public class AddDetails extends HttpServlet {
	private static final long serialVersionUID = 81L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    private Add add=new Add();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String custname = request.getParameter("name_customer");
        String custnum = request.getParameter("cust_number");
        String invoice = request.getParameter("doc_id");
        String amt = request.getParameter("total_open_amount");
        String duedate = request.getParameter("due_in_date");
        String predpaydate = request.getParameter("predicted_payment_date");
        String notes = request.getParameter("notes");
        System.out.println(notes);
        ExecutionResponse exe = new ExecutionResponse();
        exe.setCustname(custname);
        exe.setCustnumber(custnum);
        exe.setInvoice(invoice);
        exe.setAmt(amt);
        exe.setDuedate(duedate);
        exe.setNotes(notes);
        exe.setPredPayDate(predpaydate);

        try {
            add.registerEmployee(exe);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }     
        response.getWriter().write("Hello");
    }
}
