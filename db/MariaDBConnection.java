package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MariaDBConnection {
    public static void main(String[] args) {
        // DB 설정
        String url = "jdbc:mariadb://localhost:3306/board"; // DB URL
        String user = "root"; // 사용자명
        String password = "1111"; // 비밀번호

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("org.mariadb.jdbc.Driver");

            // DB 연결
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("MariaDB 연결 성공!");

            // SQL 실행 예제
            String query = "SELECT * FROM test";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Column1: " + rs.getString(1));
                System.out.println("Column2: " + rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버 로드 실패!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("DB 연결 실패!");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
