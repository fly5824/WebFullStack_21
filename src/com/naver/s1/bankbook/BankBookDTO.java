package com.naver.s1.bankbook;

public class BankBookDTO {
	
	private long bookNumber;
	private String bookname;
	private double bookRate;
	private String bookSale;
	public long getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookRate() {
		return bookRate;
	}
	public void setBookRate(double bookRate) {
		this.bookRate = bookRate;
	}
	public String getBookSale() {
		return bookSale;
	}
	public void setBookSale(String bookSale) {
		this.bookSale = bookSale;
	}
}
