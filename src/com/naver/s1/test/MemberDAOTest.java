package com.naver.s1.test;

import com.naver.s1.member.MemberDAO;
import com.naver.s1.member.MemberDTO;

public class MemberDAOTest {

	public static void main(String[] args) {
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setID("iu1");
		memberDTO.setPW("pw1");
		
		try {
			memberDTO =memberDAO.logIn(memberDTO);
			
			System.out.println(memberDTO != null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
