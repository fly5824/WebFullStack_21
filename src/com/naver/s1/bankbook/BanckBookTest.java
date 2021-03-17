package com.naver.s1.bankbook;

import java.util.List;

public class BanckBookTest {
	
	public static void main(String[] args) {
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		List<BankBookDTO> ar;
		try {
			ar = bankBookDAO.getList();
			System.out.println(ar.size() !=0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
