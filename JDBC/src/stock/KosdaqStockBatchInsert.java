package stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class KosdaqStockBatchInsert {
    public static void main(String[] args) {
        // 데이터베이스 연결 정보
        String url = "jdbc:oracle:thin:@localhost:1521:system";
        String user = "hr";
        String password = "hr";
        
        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, user, password);
            
            // 자동 커밋 비활성화 (배치 처리 성능 향상)
            conn.setAutoCommit(false);
            
            // 주식 데이터 테이블 생성 (필요한 경우)
            /*
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE KOSDAQ_STOCKS (STOCK_CODE VARCHAR2(10) PRIMARY KEY, STOCK_NAME VARCHAR2(100) NOT NULL)");
            */
            // PreparedStatement 준비
            String sql = "INSERT INTO KOSDAQ_STOCKS (STOCK_CODE, STOCK_NAME) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // 코스닥 주식 데이터 크롤링
            List<KosdaqCrawler.Stock> stocks = KosdaqCrawler.crawlKosdaqStocks();
            
            // 배치에 데이터 추가
            int batchSize = 0;
            for (KosdaqCrawler.Stock stock : stocks) {
            	
                pstmt.setString(1, stock.getCode());
                pstmt.setString(2, stock.getName());
                pstmt.addBatch();
                batchSize++;
                
                // 1000개마다 실행 (메모리 관리)
                if (batchSize % 1000 == 0) {
                    pstmt.executeBatch();
                    conn.commit();
                }
            }
            
            // 남은 배치 실행
            if (batchSize % 1000 != 0) {
                pstmt.executeBatch();
                conn.commit();
            }
            
            System.out.println("총 " + stocks.size() + "개의 코스닥 주식 데이터 삽입 완료");
            
            // 연결 종료
            pstmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
