package com.naver.s1.member;

import javax.servlet.http.HttpServletRequest;

import com.naver.s1.util.ActionForward;



public class MemberService {
	
	private MemberDAO memberDAO;
	
	
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	//memberLogin
	

	public ActionForward memberJoin(HttpServletRequest request)throws Exception{
		ActionForward actionFoward = new ActionForward();
		String method = request.getMethod();
		actionFoward.setPath("../WEB-INF/member/memberJoin.jsp");
		actionFoward.setCheck(true);
		if(method.toUpperCase().equals("POST")) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setID(request.getParameter("id"));
			memberDTO.setPW(request.getParameter("pw"));
			memberDTO.setNAME(request.getParameter("name"));
			memberDTO.setEMAIL(request.getParameter("email"));
			memberDTO.setMOBILE(request.getParameter("phone"));
			int result = memberDAO.memberJoin(memberDTO);
			actionFoward.setPath("../index.do");
			actionFoward.setCheck(false);
		}
		
		
		return actionFoward;
	}

}
