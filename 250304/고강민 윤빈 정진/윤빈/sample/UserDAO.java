package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	
	UserDAO(){
		init();
	}

	private void init() {
		try {
			Class.forName(driver);
			System.out.println("클래스 load 성공");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(UserDTO u) {
		try {
			Connection conn = DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sql = "insert into user2 values (?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,u.getName());
			stmt.setString(2,u.getId());
			stmt.setString(3,u.getAddr());
			stmt.setInt(4,u.getAge());
			int result = stmt.executeUpdate();
			System.out.println(result + "건 삽입"+"\n"+"입력이 완료되었습니다.");
			stmt.close();
			conn.close();
		}catch(Exception e) {
			
		}
	}
	
	public ArrayList<UserDTO> selectAll(){
		ArrayList<UserDTO> ulist = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sql = "select * from user2";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UserDTO u = new UserDTO();
				u.setName(rs.getString("name"));
				u.setId(rs.getString("id"));
				u.setAddr(rs.getString("addr"));
				u.setAge(rs.getInt("age"));
				ulist.add(u);
			}
		}catch(Exception e) {
			
		}
		return ulist;
	}
	public UserDTO selectOne(String id) {
        UserDTO user = null;
        try {
            Connection conn = DriverManager.getConnection(url, "system", "1111");
            String sql = "select * from user2 where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserDTO();
                user.setName(rs.getString("name"));
                user.setId(rs.getString("id"));
                user.setAddr(rs.getString("addr"));
                user.setAge(rs.getInt("age"));
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    public void update(UserDTO user) {
        try {
            Connection conn = DriverManager.getConnection(url, "system", "1111");
            String sql = "update user2 set name = ?, addr = ?, age = ?, id = ? where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getAddr());
            stmt.setInt(3, user.getAge());
            stmt.setString(4, user.getId());
            stmt.setString(5, user.getId());
            int result = stmt.executeUpdate();
            System.out.println(result + "건 수정");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

