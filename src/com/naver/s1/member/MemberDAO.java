package com.naver.s1.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	
	public int memberJoin(MemberDTO memberDTO)throws Exception {
		String user = "user01";
		String pw = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, pw);
		
		String sql = "insert into member values(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getID());
		st.setString(2, memberDTO.getPW());
		st.setString(3, memberDTO.getNAME());
		st.setString(4, memberDTO.getMOBILE());
		st.setString(5, memberDTO.getEMAIL());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
	
	public MemberDTO logIn(MemberDTO memberDTO) throws Exception {
		
		String user = "user01";
		String pw = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, pw);
		
		String sql = "select * from member where id=? and pw =?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,memberDTO.getID() );
		st.setString(2,memberDTO.getPW() );

		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			memberDTO.setNAME(rs.getString("NAME"));
			memberDTO.setEMAIL(rs.getString("EMAIL"));
			memberDTO.setMOBILE(rs.getString("MOBILE"));
					}else {
		memberDTO=null;	
		}
		
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
		 
		
		
	}

}
