package com.higradius;

public class Response {
private String CustName;
private String CustNo;
private String InvoiceID;
private String InvoiceAmount;
private String DueDate;
private String PredPayDate;
private String Notes;


public String getCustName() {
	return CustName;
}

public String getCustNo() {
	return CustNo;
}


public String getInvoiceID() {
	return InvoiceID;
}


public String getInvoiceAmount() {
	return InvoiceAmount;
}


public String getDueDate() {
	return DueDate;
}


public String getNotes() {
	return Notes;
}

public String getPredPayDate() {
	return PredPayDate;
}


public void setCustName(String CustName) {
	this.CustName=CustName;
}


public void setCustNo(String CustNo) {
	this.CustNo=CustNo;
}


public void setInvoiceID(String InvoiceID) {
	this.InvoiceID = InvoiceID;
}


public void setInvoiceAmount(String InvoiceAmount) {
	this.InvoiceAmount = InvoiceAmount;
}


public void setDueDate(String DueDate) {
	this.DueDate = DueDate;
}


public void setPredPayDate(String PredPayDate) {
	this.PredPayDate=PredPayDate;
}


public void setNotes(String Notes) {
	this.Notes=Notes;
}

}