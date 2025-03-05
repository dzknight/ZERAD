package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//책임: 데이터베이스 쿼리작업
public class UserDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private Connection conn;
	
	UserDAO(){
		init();
	}
	
	

	private void init() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(url,"system","1111");
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void insert(UserDTO u) {
		try {
			String sql = "insert into user1 values(?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,u.getName());
			psmt.setString(2,u.getId());
			psmt.setString(3,u.getAddr());
			psmt.setString(4,u.getAge()+"");
			int result = psmt.executeUpdate();
			System.out.println(result+"개 입력!");
			
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



	public ArrayList<UserDTO> load() {
		ArrayList<UserDTO> ulist=new ArrayList<>();
		
		try {
			String sql = "select * from user1";
			Statement psmt = conn.createStatement();
			ResultSet rs=psmt.executeQuery(sql);

			while(rs.next()) {
				UserDTO u=new UserDTO();
				u.setName(rs.getString(1));
				u.setId(rs.getString(2));
				u.setAddr(rs.getString(3));
				u.setAge(rs.getInt(4));
				ulist.add(u);
			}
			
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ulist;
	}

	public void delete(String name) {
		try {
			String sql = "delete from user1 where name = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,name);

			int result = psmt.executeUpdate();
			System.out.println(result+"개 삭제");
			
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



	public void update(UserDTO u) {
		try {
			String sql = "update user1 set id=?, addr=? ,age=? where name=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,u.getId());
			psmt.setString(2,u.getAddr());
			psmt.setString(3,u.getAge()+"");
			psmt.setString(4,u.getName());
			int result = psmt.executeUpdate();
			System.out.println(result+"개 변경!");
			
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void exit() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
