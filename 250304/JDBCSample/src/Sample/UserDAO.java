package Sample;
import java.sql.*;

import java.util.ArrayList;

//���� å�� : �����ͺ��̽����� CRUD �۾� �����ϴ� ������ �ϰ� �ִ�. 
public class UserDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:orcl";
	// DBMS �ּ� : ��Ʈ��ȣ : �����ͺ��̽� �̸�

	
	UserDAO(){
		init();
	}
	
	private void init() {
		try {
			Class.forName(driver);
			//���̺귯���� �ε��ϴ� �ǹ�.
			//�� ���̺귯���� ����Ŭ�� CRUD�� ���� Ŭ�������� ����
			System.out.println("Ŭ���� load ����");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//JDBC CREATE
	public void insert(UserDTO u) {
		try {
			Connection conn = DriverManager.getConnection(url,"system","1111");
			System.out.println("���Ἲ��");
			// ������ ����
			String sql = "insert into user1 values (?,?)";
			// statement ����
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getId());
			//���� ���� �� ����� �ޱ�
			int result = stmt.executeUpdate();
			System.out.println(result + "�� ����");
			//�������� - �ڿ��ݳ�
			stmt.close();
			conn.close();
		}catch (Exception e) {
			
			
		}
	}
	
	//JDBC READ
	public ArrayList<UserDTO> selectAll() {
		ArrayList<UserDTO> ulist = new ArrayList<>();
		try {
			
			//���� ����, ���� �����, ����, ���� ����, ���ϰ� �ޱ�
			Connection conn = DriverManager.getConnection(url,"system","1111");
			System.out.println("���Ἲ��");
			String sql = "select * from user1";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				UserDTO u = new UserDTO();
				u.setId(rs.getString("id"));
				u.setName(rs.getString("name"));
				ulist.add(u);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ulist;
		
		
	}
	

}
