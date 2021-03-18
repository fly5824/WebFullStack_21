package com.naver.s1.bankbook;

import java.util.List;

public class BanckBookTest {
	
	public static void main(String[] args) {
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		try {
			BankBookDTO bankBookDTO = bankBookDAO.getSelect(200);
			System.out.println(bankBookDTO !=null);
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
//		List<BankBookDTO> ar;
//		try {
//			ar = bankBookDAO.getList();
//			System.out.println(ar.size() !=0);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
}