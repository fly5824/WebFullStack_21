package com.naver.s1.test;

import com.naver.s1.member.MemberDAO;
import com.naver.s1.member.MemberDTO;

public class MemberDAOTest {

	public static void main(String[] args) {
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setID("id3");
		memberDTO.setPW("pw3");
		memberDTO.setNAME("pw3");
		memberDTO.setEMAIL("pw3@naver.com");
		memberDTO.setMOBILE("01033333333");
		
		
		try {
			int result =memberDAO.memberJoin(memberDTO);
			
			System.out.println(result != 0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
