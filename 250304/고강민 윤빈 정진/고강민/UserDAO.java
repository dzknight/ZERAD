package sample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	// DBMS주소: 포트번호:
	
	private Connection conn;


	
	UserDAO(){
		init();
		try {
			conn = DriverManager.getConnection(url,"system","1111");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void init() {
		
		try {
			Class.forName(driver);
			//라이브러리를 로드하는 의미
			//이 라이브러리는 오라클에 CURD를 위한 클래스들이 있음
			System.out.println("클래스 load 성공");			
		} catch (ClassNotFoundException e) { 
			// ClassNotFoundException e는 자바에서 클래스를 찾을 수 없을 때 
			//발생하는 예외를 처리하기 위해 try-catch 문에서 사용되는 예외 객체입니다.
			e.printStackTrace();
			
		}
		
		
		
		
	}
	
	public void insert(UserDTO u) {
		try {
			//연결하기
			//Connection conn = DriverManager.getConnection(url,"system","1111");
			
			System.out.println("연결성공");
			//쿼리문 정의 
			String sql = "insert into user2 values(?,?,?,?)";
			//statment 생성
			//데이터베이스 연결 객체를 사용해 쿼리문을 준비하고 실행할수 있는 개체 생성
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getName()); //첫번째 물음표에 이름 설정
			stmt.setString(2, u.getId()); //두번째 물음표에 아이디 설정
			stmt.setString(3, u.getAddr()); //세번째 물음표에 주소 설정
			stmt.setInt(4, u.getAge()); //네번째 물음표에 나이 설정
			//쿼리 전송 및 결과값 받기
			int result = stmt.executeUpdate();
			System.out.println(result + "건 삽입");
			//연결해제 - 자원반납
			stmt.close();
			
			
			
			
		} catch (Exception e) {
			System.out.println("연결실패");
			// 자바에서 발생할 수 있는 모든 종류의 예외를 처리하기 위한 일반적인 예외 객체
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<UserDTO> selectAll(){
		ArrayList<UserDTO> ulist = new ArrayList<>();
		try {
			//연결 설정, 쿼리만들기, 매핑, 쿼리실행, 리턴값 받기
			//Connection conn = DriverManager.getConnection(url,"system","1111");
			System.out.println("연결 성공");
			String sql = "select * from user2";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UserDTO u = new UserDTO();
				u.setId(rs.getString("id"));
				u.setName(rs.getString("name"));
				u.setAddr(rs.getString("addr"));
				u.setAge(rs.getInt("age"));
				ulist.add(u);

			}
			
			
		} catch (Exception e) {
			System.out.println("연결실패");
			e.printStackTrace();
		
		}
		return ulist;

	}
	

}
