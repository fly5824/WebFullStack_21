package com.naver.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.naver.s1.util.ActionForward;

public class BankBookService {
	
	private BankBookDAO bankBookDAO;
	
	public void setBankBookDAO(BankBookDAO bankBookDAO) {
		this.bankBookDAO = bankBookDAO;
	}
	
	public ActionForward setWrite(HttpServletRequest request) throws Exception {
		ActionForward actionForward = new ActionForward();
		
		System.out.println("setwrite");
		
		//get
		actionForward.setPath("../WEB-INF/bankbook/bankbookWrite.jsp");
		actionForward.setCheck(true);
		
		if(request.getMethod().toUpperCase().equals("POST")) {
			System.out.println(request.getParameter("bookName"));
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookname(request.getParameter("bookName"));
			bankBookDTO.setBookRate(Integer.parseInt(request.getParameter("bookRate")));
			bankBookDTO.setBookSale(request.getParameter("bookSale"));
			
			//dao 작업
			int result = bankBookDAO.setWrite(bankBookDTO);
			
			actionForward.setPath("./bankbookList.do");
			actionForward.setCheck(false);
		}
		
		return actionForward;
	}
	
	
	
	
	public ActionForward getSelect(HttpServletRequest request) throws Exception {
		
		ActionForward actionForward = new ActionForward();
		
		int bookNumber = Integer.parseInt(request.getParameter("bookNumber"));
		
		BankBookDTO bankBookDTO = bankBookDAO.getSelect(bookNumber);
		
		actionForward.setCheck(true);
		actionForward.setPath("../WEB-INF/bankbook/bankbookSelect.jsp");
		request.setAttribute("dto", bankBookDTO);
		
		return actionForward;
	}
	
	
	private int parseInt(String parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	//get list dao의 getlist 호출
	public ActionForward getList(HttpServletRequest request) throws Exception{
		ActionForward actionForward = new ActionForward();
		List<BankBookDTO> ar = bankBookDAO.getList();
		
		request.setAttribute("list", ar);
		actionForward.setPath("../WEB-INF/bankbook/bankbookList.jsp");
		// 프로젝트명 = 루트  /  -> jsp가 있는 곳의 상대경로 
		actionForward.setCheck(true);
		//true면 포워드 false면 리다이렉트
		
		return actionForward;
	}

}
