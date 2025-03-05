package Tset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class UserDAO {
	private String driver="oracle.jdbc.driver.OracleDriver"; // <-- 고정주소인지 알아보기
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // <-- DBMS주소 : 포트번호 : 데이터베이스 이름
	
	
	UserDAO(){
		init();
	}
	public void init() {
		try {
			Class.forName(driver); // ← 라이브러리 
			System.out.println("클래스 load 성공");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void insert(UserDTO u) { // 등록
		try {
			Connection conn = DriverManager.getConnection(url,"system","1111");
			System.out.println("접속성공");
			String sql = "insert into word values (?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql); // <--객체먼저 생성
			stmt.setString(1, u.getEnglish());
			stmt.setString(2, u.getKorean());
			int result = stmt.executeUpdate();
			System.out.println(result+"건 삽입");
			stmt.close();
			conn.close();
		}catch(Exception e) {
		}
	}
	public void update(){ // 수정하기
		try {
			Scanner s= new Scanner(System.in);
			System.out.println("기존 english를 입력해주세요");
			String english = s.nextLine();
			System.out.println("변경할 english를 입력하세요");
			String name = s.nextLine();
			System.out.println("변경할 korean을 입력하세요");
			String name1 = s.nextLine();
			System.out.println("Test");
			Connection conn = DriverManager.getConnection(url,"system","1111");
			System.out.println("접속성공");
			String sql = "update word set english=?,korean=? where english=?";
			PreparedStatement stmt = conn.prepareStatement(sql); // <--객체먼저 생성
			stmt.setString(1, name);
			stmt.setString(2, name1);
			stmt.setString(3, english);
			int result = stmt.executeUpdate();
			System.out.println(result+"건 수정");
			stmt.close();
			conn.close();
		}catch(Exception e) {
		}
	}
	public void delete(){ // 삭제하기
		try {
			Scanner s= new Scanner(System.in);
			System.out.println("접속성공");
			System.out.println("삭제할 english를 입력하세요");
			String name = s.nextLine();
			Connection conn = DriverManager.getConnection(url,"system","1111");
			String sql = "delete from word where english=?";
			PreparedStatement stmt = conn.prepareStatement(sql); // <--객체먼저 생성
			stmt.setString(1, name);
			int result = stmt.executeUpdate();
			System.out.println(result+"건 수정");
			stmt.close();
			conn.close();
		}catch(Exception e) {
		}
	}
	public ArrayList<UserDTO> selectAll(){
		ArrayList<UserDTO> wlist = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sql = "select * from word";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				UserDTO u = new UserDTO();
				u.setEnglish(rs.getString("english"));
				u.setKorean(rs.getString("korean"));
				wlist.add(u);
			}
		}catch(Exception e) {
			
		}
		return wlist;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
