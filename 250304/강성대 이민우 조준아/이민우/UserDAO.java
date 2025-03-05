package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

//데이터 베이스에 CRUD 작업 수행
public class UserDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
							//DBMS 		주소 : 포트번호 : 데이터베이스 이름
	Connection conn = null;
	UserDAO(){
		init();
	}
	public Connection connection() {
		
		try {
			conn=DriverManager.getConnection(url, "system", "1111");
			System.out.println("연결 성공");
			return conn;
			
		} catch (Exception e) {
			
		}
		
		return conn;
	}
	
	private void init() {
		try {
			Class.forName(driver);
			System.out.println("클래스 load 성공");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<UserDTO> selectAll(){
		ArrayList<UserDTO> ulist = new ArrayList<>();
		try {
			conn=connection();
			if(conn!=null) {
				
				String sql = "select* from lib_id";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					UserDTO u = new UserDTO();
					u.setName(rs.getString("id"));
					u.setNum(rs.getInt("num"));
					ulist.add(u);
				}
			}
		} catch (Exception e) {
		}
		return ulist;
	}
	
	
	public void insert(UserDTO u) {
		try {
			 conn = connection();
			if(conn!=null) {
				String sql = "insert into lib_id values(?, ?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, u.getName());
				stmt.setInt(2, u.getNum());
				stmt.executeUpdate();
				
				stmt.close();
				conn.close();
			}	
		} catch(Exception e) {
			
		}
	}
	
	public void delete(String id) {
		try {
			conn = connection();
			if(conn!=null) {
				String sql = "delete from lib_id where id=?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, id);
				stmt.executeUpdate();
				
				stmt.close();
				conn.close();
			}
		} catch(Exception e) {
			
		}
	}
	
	public void update(String id, int num) {
		try {
			 conn = connection();
			 if(conn!=null) {	
				 String sql = "update lib_id set num = ? where id=?";
				 PreparedStatement stmt = conn.prepareStatement(sql);
				 stmt.setInt(1, num);
				 stmt.setString(2, id);
				 stmt.executeUpdate();
				 
				 stmt.close();
				 conn.close();
			 }
		} catch(Exception e) {
			
		}
	}
}
