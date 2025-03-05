package sample;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
// 책임 : 데이터 베이스에 CRUD작업 수행
public class UserDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	UserDAO(){
		init();
	}
	private void init() {
		try {
			Class.forName(driver);
			System.out.println("클래스 losd 성공");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	private Connection con() {
		try {
			Connection conn=DriverManager.getConnection(url, "system", "1111");
			System.out.println("연결성공");
			return conn;
		} catch (SQLException e) {
		}
		return null;
	}
	public void insert(UserDTO u) {
		try {
			Connection conn=con();
			// 쿼리문 정의
			String sql="insert into user1 values (?,?)";
			// statement 생성
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getId());
			// 쿼리 전송 및 결과 값 받기
			int result = stmt.executeUpdate();
			System.out.println(result+"건 삽입");
			// 연결 해제 - 자원반납
			stmt.close();
			conn.close();
		}catch(Exception e) {
		}
	}
	public ArrayList<UserDTO> selectAll(){
		ArrayList<UserDTO> ulist=new ArrayList<>();
		try {
			Connection conn=con();
			String sql ="select * from user1";
			java.sql.Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				UserDTO u=new UserDTO();
				u.setId(rs.getString("id"));
				u.setName(rs.getString("name"));
				ulist.add(u);
			}
		}catch(Exception e) {
		}
		return ulist;
	}
	public void del(UserDTO u) {
		try {
			Connection conn=con();
			String sql ="delete from user1 where id=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, u.getId());
			stmt.executeUpdate();
		}catch(Exception e) {
		}
	}
	public void up(UserDTO u) {
		try {
			Connection conn=con();
			String sql ="update user1 set name=? where id=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getId());
			stmt.executeUpdate();
		}catch(Exception e) {
		}
	}
}
