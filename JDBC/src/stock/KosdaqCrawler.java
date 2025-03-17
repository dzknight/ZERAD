package stock;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KosdaqCrawler {
    public static List<Stock> crawlKosdaqStocks() {
        List<Stock> stocks = new ArrayList<>();
        try {
            // 코스닥 상장 주식 정보가 있는 페이지 URL (예시)
            String url = "https://finance.daum.net/domestic/kosdaq";
            
            // Selenium 또는 JSoup을 사용하여 페이지 내용 가져오기
            Document doc = Jsoup.connect(url).get();
            
            // 적절한 CSS 선택자를 사용하여 주식 정보 추출
            Elements stockElements = doc.select("table.stockList tr");
            
            for (Element element : stockElements) {
                String code = element.select("td.code").text();
                String name = element.select("td.name").text();
                
                if (!code.isEmpty() && !name.isEmpty()) {
                    stocks.add(new Stock(code, name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stocks;
    }
    
    // 주식 정보를 담을 클래스
    static class Stock {
        private String code;
        private String name;
        
        public Stock(String code, String name) {
            this.code = code;
            this.name = name;
        }
        
        // Getter 메서드
        public String getCode() { return code; }
        public String getName() { return name; }
    }
}