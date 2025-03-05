package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class UserDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	
	UserDAO(){
		init();
	}

	private void init() {
		try {
			Class.forName(driver);
			System.out.println("클래스 load 성공");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(UserDTO u) {
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="insert into libuser values(?,?,default)";
			PreparedStatement stmt=conn.prepareStatement(sq1);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getUnum());
			int result=stmt.executeUpdate();
			System.out.println(result+"건 삽입");
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public ArrayList<UserDTO> selectall(){
		ArrayList<UserDTO> list=new ArrayList<>();
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="select * from libuser";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sq1);
			while(rs.next()) {
				UserDTO u= new UserDTO();
				u.setName(rs.getString("name"));
				u.setUnum(rs.getString("unum"));
				u.setBook(rs.getInt("book"));
				list.add(u);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {

		}
		return list;
	}

	public void modify(String name, String name2) {
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="update libuser set name=? where name=?";
			PreparedStatement stmt=conn.prepareStatement(sq1);
			stmt.setString(1, name2);
			stmt.setString(2, name);
			int result=stmt.executeUpdate();
			System.out.println(result+"건 수정");
			stmt.close();
			conn.close();
		} catch (Exception e) {
			
		}
	}

	public void delete(String name) {
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="delete from libuser where name=?";
			PreparedStatement stmt=conn.prepareStatement(sq1);
			stmt.setString(1, name);
			int result=stmt.executeUpdate();
			System.out.println(result+"건 삭제");
			stmt.close();
			conn.close();
		} catch (Exception e) {
			
		}
		
	}
	
	private void connect() {	
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
		} catch (Exception e) {
			
		}
	
	}
}

