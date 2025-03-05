package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:system";
	private String id="hr";
	private String pass="hr";
	private Connection conn=null;
	private static UserDAO userdao=null;		
	//
	private UserDAO(){
		init();//생성자 타입으로 객체 못만든다
	}
	
	public static UserDAO getInstance() {
		if(userdao==null) {
			userdao=new UserDAO();
		}
		return userdao;
	}
	private Connection getConnenction() {
//		if(conn==null) {
			try {
				conn= DriverManager.getConnection(url, id, pass);
				System.out.println("연결성공");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("연결오류");
			}
//		}
		return conn;
	}
	private void init() {
		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
			//라이브러리를 로드라라는 뜻
			//이 라이브러리는 crud를 위한 클래스들이 있음
			System.out.println("클래스 로드 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("클래스로드실패");
			e.printStackTrace();
		}
		
	}
	
	public void del(UserDTO u) {
		try {
			conn = getConnenction();
			System.out.println("연결성공");
			String sql =  "DELETE FROM user1 WHERE id = ?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			// sql문 전송, 실행
			stmt.setString(1, u.getId());
			stmt.executeUpdate();
			
			int result =stmt.executeUpdate();
			System.out.println(result+"건 삭제");
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public void insert(UserDTO u) {
		conn = getConnenction();
		PreparedStatement stmt=null;
		try {
			if(getConnenction()!=null) {
				String sql = "insert into user1 values (?,?)";
				 stmt=conn.prepareStatement(sql);
				System.out.println("연결성공");
				// sql문 전송, 실행
				stmt.setString(1, u.getName());
				stmt.setString(2, u.getId());
				stmt.executeUpdate();
				
				int result =stmt.executeUpdate();
				System.out.println(result+"건 삽입");
			}
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//연결해제 자원반납
				stmt.close();
				conn.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
       
        //단어전체 검색

	  
	}

	public ArrayList<UserDTO> selectAll() {
		// TODO Auto-generated method stub
		//메뉴출력
		ArrayList<UserDTO> ulist=new ArrayList<>();
		try {
			//연결 설정, 쿼리만들기 매핑 쿼라ㅣ실행,리턴값 받기
			if(getConnenction()!=null) {
				
				conn = getConnenction();
				
				String sql="select * from user1";
				java.sql.Statement stmt=conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					UserDTO u=new UserDTO();
					u.setId(rs.getString("id"));
					u.setName(rs.getString("name"));
					ulist.add(u);
				}
			}
		}
		 catch (SQLException e) {
		// TODO Auto-generated catch block
		 } finally {
			 
		 }
	return ulist;

	}	
}
