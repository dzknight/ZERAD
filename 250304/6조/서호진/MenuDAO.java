package menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	
	MenuDAO(){
		init();
	}
	private void init() {
		try {
			Class.forName(driver);
			System.out.println("클래스 로드 성공");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void insert(MenuDTO m) {
		try {
			Connection conn = conn();
			if(conn != null)
				System.out.println("연결 성공");
			else
				return;
			String sql = "insert into Menu values(?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, m.getNum());
			stmt.setString(2, m.getMenu());
			stmt.setInt(3, m.getPrice());
			
			int result = stmt.executeUpdate();
			System.out.println(result+"건 삽입");
			
			stmt.close();
			conn.close();
		}catch (Exception e) {
			
		}
	}
	public ArrayList<MenuDTO> selectAll(){
		ArrayList<MenuDTO> mList = new ArrayList<>();
		
		try {
			Connection conn = conn();
			if(conn != null)
				System.out.println("연결 성공");
			else
				return null;
			String sql = "select * from Menu";
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MenuDTO m = new MenuDTO();
				
				m.setNum(rs.getInt("num"));
				m.setMenu(rs.getString("menu"));
				m.setPrice(rs.getInt("price"));
				
				mList.add(m);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return mList;
	}
	public void delete(int num) {
		try {
			Connection conn = conn();
			if(conn != null)
				System.out.println("연결 성공");
			else
				return;
			String sql = "delete from Menu where num = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, num);
			
			int result = stmt.executeUpdate();
			
			if(result > 0)
				System.out.println("삭제 성공");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void mod(int num) {
		try {	
			Scanner in = new Scanner(System.in);
			Connection conn = conn();
			if(conn != null)
				System.out.println("연결 성공");
			else
				return;
			String sql = "update Menu set price = ?, menu = ? where num = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			System.out.println("새로운 메뉴을 입력하세요");
			String menu = 	in.nextLine();
			
			System.out.println("새로운 가격을 입력하세요");
			int price = in.nextInt();
			in.nextLine();
			
			stmt.setInt(1, price);
			stmt.setString(2, menu);
			stmt.setInt(3, num);
			
			int result = stmt.executeUpdate();
			
			if(result > 0)
				System.out.println("수정 성공");
			else
				System.out.println("수정 실패");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public Connection conn() {
		try {
			return DriverManager.getConnection(url,"system","1111");
		} catch (Exception e) {
			System.out.println("연결 실패");
			return null;
		}
	}
}
