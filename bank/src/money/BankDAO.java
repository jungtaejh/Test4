package money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BankDAO {
	
	public void insert(BankDTO dto) throws Exception {

		//1. 드라이버(connector) 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. DB연결 - DB명 + 유저ID + 유저PW
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String password = "1234";
		
		//3.SQL문 객체화
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into money value(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
	
		//4.SQL문 실행 요청
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setInt(3, dto.getAge());
		ps.setString(4, dto.getTel());
		
		ps.executeUpdate();
		con.close();
		ps.close();
}
	
	public void update(String tel, String id) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update money set tel = ? where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, tel);
		ps.setString(2, id);
		ps.executeUpdate();		
		
		con.close();
		ps.close();
		
	}

	public ArrayList<BankDTO> select(String Id) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from money where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, Id);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<BankDTO> list = new ArrayList<BankDTO>();
		BankDTO dto;
		
		while (rs.next()) {
			dto = new BankDTO();
			
			dto.setId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setAge(rs.getInt(3));
			dto.setTel(rs.getString(4));
			
			list.add(dto);
		}
		con.close();
		ps.close();
		rs.close();

		return list;
	}
	
	public ArrayList<BankDTO> selectAll() throws Exception { 
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from money";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		BankDTO dto = null;
		ArrayList<BankDTO> list = new ArrayList<>();
		
		while(rs.next()) {
			dto = new BankDTO();
			
			String id = rs.getString(1);
			String name = rs.getString(2);
			int age = rs.getInt(3);
			String tel = rs.getString(4);
			
			dto.setId(id);
			dto.setName(name);
			dto.setAge(age);
			dto.setTel(tel);
			
			list.add(dto);	
	}
		return list;
	
}
	
	public void delete(String ID) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "delete from money where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, ID);
		ps.executeUpdate();

		con.close();
		ps.close();
	}
	
}

