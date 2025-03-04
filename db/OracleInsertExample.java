package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleInsertExample {
    public static void main(String[] args) {
        // 오라클 데이터베이스 연결 정보
        String url = "jdbc:oracle:thin:@localhost:1521:system"; // XE는 기본 오라클 Express Edition 데이터베이스 이름
        String user = "scott"; // 사용자 이름
        String password = "tiger"; // 비밀번호

        // SQL INSERT문
        String sql = "INSERT INTO EMPLOYEES (EMP_ID, NAME, DEPARTMENT, SALARY) VALUES (?, ?, ?, ?)";

        try {
            // 1. JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. 데이터베이스 연결
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("오라클 데이터베이스에 연결되었습니다.");

            // 3. PreparedStatement 객체 생성
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // 4. 값 설정 및 SQL 실행
            pstmt.setInt(1, 101); // EMP_ID
            pstmt.setString(2, "John Doe"); // NAME
            pstmt.setString(3, "IT"); // DEPARTMENT
            pstmt.setDouble(4, 75000); // SALARY

            int rowsInserted = pstmt.executeUpdate(); // 실행 결과 반환 (삽입된 행 수)
            if (rowsInserted > 0) {
                System.out.println("데이터가 성공적으로 삽입되었습니다.");
            }

            // 5. 자원 해제
            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("데이터베이스 작업 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
