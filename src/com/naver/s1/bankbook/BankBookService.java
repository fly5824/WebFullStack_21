package com.naver.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.naver.s1.util.ActionForward;

public class BankBookService {
	
	private BankBookDAO bankBookDAO;
	
	public void setBankBookDAO(BankBookDAO bankBookDAO) {
		this.bankBookDAO = bankBookDAO;
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
