package com.naver.s1.member;

import javax.servlet.http.HttpServletRequest;

import com.naver.s1.util.ActionForward;

public class MemberService {

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	
	public ActionForward memberJoin(HttpServletRequest request) throws Exception {
		//DAO메서드 호출
		
		System.out.println("member Service");
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		actionForward.setPath("../WEB-INF/member/memberJoin.jsp");
		
		if(method.toUpperCase().equals("POST")) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setID(request.getParameter("ID"));
			memberDTO.setPW(request.getParameter("PW"));
			memberDTO.setNAME(request.getParameter("NAME"));
			memberDTO.setEMAIL(request.getParameter("EMAIL"));
			memberDTO.setMOBILE(request.getParameter("MOBILE"));
			int result = memberDAO.memberJoin(memberDTO);
			actionForward.setPath("../index.jsp");
		}
		
		return actionForward;
	}
}
