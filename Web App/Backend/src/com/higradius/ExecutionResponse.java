package com.higradius;

public class ExecutionResponse {
private String custname;
private String custnumber;
private String invoice;
private String amt;
private String duedate;
private String notes;
private String preddate;
public String getCustname() {
	return custname;
}
public void setCustname(String custname) {
	this.custname = custname;
}
public String getCustnumber() {
	return custnumber;
}
public void setCustnumber(String custnumber) {
	this.custnumber = custnumber;
}
public String getInvoice() {
	return invoice;
}
public void setInvoice(String invoice) {
	this.invoice = invoice;
}
public String getAmt() {
	return amt;
}
public void setAmt(String amt) {
	this.amt = amt;
}
public String getDuedate() {
	return duedate;
}
public void setDuedate(String duedate) {
	this.duedate = duedate;
}

public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}

public String getPredPayDate() {
	return preddate;
}
public void setPredPayDate(String preddate) {
	this.preddate = preddate;
}


}
