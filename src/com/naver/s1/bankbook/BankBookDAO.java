package com.naver.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankBookDAO {


	public int setWrite(BankBookDTO bankBookDTO)throws Exception{
		String user = "user01";
		String pw = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);

		Connection con = DriverManager.getConnection(url, user, pw);

		String sql = "insert into bankbook values(bank_seq.nextval,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, bankBookDTO.getBookname());
		st.setInt(2, bankBookDTO.getBookRate());
		st.setString(3, bankBookDTO.getBookSale());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	public List<BankBookDTO> getList()throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList<>();

		String user = "user01";
		String pw = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);

		Connection con = DriverManager.getConnection(url, user, pw);

		String sql ="select * from bankbook";

		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			System.out.println("count");
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNumber(rs.getInt("bookNumber"));
			bankBookDTO.setBookname(rs.getString("bookname"));
			bankBookDTO.setBookRate(rs.getInt("bookRate"));
			bankBookDTO.setBookSale(rs.getString("bookSale"));

			ar.add(bankBookDTO);
		}
		rs.close();
		st.close();
		con.close();

		return ar;
	}

	public BankBookDTO getSelect(int bookNumber)throws Exception {

		String user = "user01";
		String pw = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);

		Connection con = DriverManager.getConnection(url, user, pw);

		String sql ="select * from bankbook where bookNumber=?";

		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, bookNumber);

		ResultSet rs = st.executeQuery();


		BankBookDTO bankBookDTO = null;

		if(rs.next()) {
			bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNumber(rs.getInt("bookNumber"));
			bankBookDTO.setBookname(rs.getString("bookname"));
			bankBookDTO.setBookRate(rs.getInt("bookRate"));
			bankBookDTO.setBookSale(rs.getString("bookSale"));

		}


		rs.close();
		st.close();
		con.close();

		return bankBookDTO;
	}
}
