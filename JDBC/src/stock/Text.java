package stock;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Text {

	public static void main (String []args)
    {
        String url = "https://news.naver.com";
        //가져오고 싶은 정보가 있는 웹페이지의 url
        Document doc = null;
        
        try{
            doc = Jsoup.connect(url).get(); //Document에 url 페이지의 데이터를 가져온다.
            System.out.println(doc.toString());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        //1. 타이틀 가져오기

        //String title = doc.select("div.com_header").text().substring(0,9);
        //클래스 이름으로 가져오기
        String title = doc.select("h4").text().substring(0,40);
        //위와 같이 id로 가져올 수도 있다.


        //2. 주요 헤드라인들 가져오기
        Elements element =  doc.select("div.newsnow");
        //newsnow클래스를 저장

        System.out.println("============================================");
        System.out.println(title);//타이틀 출력
        System.out.println("============================================");
        for(Element el : element.select("li")){
            System.out.println(el.text());
            //newsnow클래스 내의 li란 id를 가지고 있는 태그의 텍스트를 for문으로 순차적으로 가져와 .
        }
        System.out.println("============================================");
    }
}

