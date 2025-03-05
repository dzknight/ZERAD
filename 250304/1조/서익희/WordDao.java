package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordDao {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:system";
	
	public ArrayList<WordDto> select() {
		// TODO Auto-generated method stub
		ArrayList<WordDto> wlist=new ArrayList<WordDto>();
		
		
		try {
			Connection conn=DriverManager.getConnection(url,"hr","hr");
			String sql="select * from wordtable where engword like ?";
			System.out.println("검색어를 입력하세요");
			Scanner in =new Scanner(System.in);
			String eng=in.nextLine();
			
			java.sql.PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery(sql);
			while(rs.next()) {
				WordDto w=new WordDto();
				w.setEngword(rs.getString("engword"));
				w.setKrmean(rs.getString("krword"));
				w.setInidate(rs.getDate("inidate"));
				wlist.add(w);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wlist;
	}
	public ArrayList<WordDto> selectAll() {
		// TODO Auto-generated method stub
		
		ArrayList<WordDto> wlist=new ArrayList<>();
		
		try {
			Connection conn=DriverManager.getConnection(url,"hr","hr");
			String sql="select * from wordtable";
			java.sql.Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				WordDto w=new WordDto();
				w.setEngword(rs.getString("engword"));
				w.setKrmean(rs.getString("krword"));
				w.setInidate(rs.getDate("inidate"));
				wlist.add(w);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wlist;
	}
	
	WordDao(){
		init();//처음에 모두 실행
	}

	private void init() {
		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
			//라이브러리를 로드
			System.out.println("클래스 로드 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(WordDto w) {
		try {
			Connection conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("연결성공");
			String sql = "insert into wordtable values (?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, w.getEngword());
			stmt.setString(2, w.getKrmean());
			stmt.setDate(3, w.getInidate());
			
			int result=stmt.executeUpdate();
			System.out.println(result+"건 삽입");
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
