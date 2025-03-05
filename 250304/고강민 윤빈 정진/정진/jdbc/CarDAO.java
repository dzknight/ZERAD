package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CarDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private Connection conn;
	CarDAO(){
		init();
	}
	
	private void init() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(url,"system","1111");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insert(CarDTO c) {
		try {
			String sql = "insert into car1 values(?,?,default)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,c.getId());
			psmt.setString(2,c.getNum());
			int result = psmt.executeUpdate();
			System.out.println(result+"개 입력!");
			

			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



	public ArrayList<CarDTO> load() {
		ArrayList<CarDTO> clist=new ArrayList<>();
		
		try {
			String sql = "select * from car1";
			Statement psmt = conn.createStatement();
			ResultSet rs=psmt.executeQuery(sql);

			while(rs.next()) {
				CarDTO c=new CarDTO();
				c.setId(rs.getString(1));
				c.setNum(rs.getString(2));
				c.setIndate(rs.getString(3));
				clist.add(c);
			}
			

			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clist;
	}

	public void delete(String name) {
		try {
			String sql = "delete from car1 where num = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,name);

			int result = psmt.executeUpdate();
			System.out.println(result+"개 삭제");
			
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



	public void update(CarDTO c) {
		try {
			String sql = "update car1 set num=? where id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,c.getNum());
			psmt.setString(2,c.getId());
		
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
