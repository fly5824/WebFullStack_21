package com.naver.s1.bankbook;

public class BankBookDTO {
	
	private int bookNumber;
	private String bookname;
	private int bookRate;
	private String bookSale;
	
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getBookRate() {
		return bookRate;
	}
	public void setBookRate(int bookRate) {
		this.bookRate = bookRate;
	}
	public String getBookSale() {
		return bookSale;
	}
	public void setBookSale(String bookSale) {
		this.bookSale = bookSale;
	}
}
