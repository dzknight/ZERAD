package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	
	BookDAO(){
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
	
	public void insert(BookDTO b) {
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="insert into booklist values(?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(sq1);
			stmt.setString(1, b.getName());
			stmt.setString(2, b.getBname());
			stmt.setString(3, b.getBdate());
			int result=stmt.executeUpdate();
			String sq2="update libuser set book=book+1 where name=?";
			PreparedStatement stmt2=conn.prepareStatement(sq2);
			stmt2.setString(1, b.getName());
			System.out.println(result+"건 삽입");
			stmt.close();
			conn.close();
		} catch (Exception e) {
			
		}
	}
	
	public void delete(String bname) {
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="delete from booklist where bname=?";
			PreparedStatement stmt=conn.prepareStatement(sq1);
			stmt.setString(1, bname);
			String sq2="update libuser set book=book-1 where name=?";
			PreparedStatement stmt2=conn.prepareStatement(sq2);
			stmt2.setString(1,selectname(bname));
			int result=stmt.executeUpdate();
			System.out.println(result+"건 삭제");
			stmt.close();
			conn.close();
		} catch (Exception e) {
			
		}
		
	}
	
	private String selectname(String bname) {
		String name=null;
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="select name from booklist where bname=?";
			PreparedStatement stmt=conn.prepareStatement(sq1);
			stmt.setString(1, bname);
			ResultSet rs=stmt.executeQuery(sq1);
			name=rs.getString("name");
		} catch (Exception e) {
			
		}
		return name;
	}
	
	
	
	
	
	
}
