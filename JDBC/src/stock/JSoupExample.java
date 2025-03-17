package stock;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JSoupExample {
    public static void main(String[] args) {
    	JEditorPane editorPane = new JEditorPane();
        try {
            // Jsoup으로 웹사이트의 HTML 가져오기 및 수정하기
            Document doc = Jsoup.connect("https://news.naver.com").get();
//            Document doc = Jsoup.connect("https://news.naver.com").get();
            doc.select("h1").first().text("Jsoup으로 변경된 제목");
            
            // Swing GUI 생성 및 HTML 표시하기
            editorPane.setContentType("text/html");
            editorPane.setEditable(true);
            editorPane.setText(doc.html());
            editorPane.setSize(50,50);
            JFrame frame = new JFrame("Jsoup HTML Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1024, 800);
            
            JScrollPane scrollPane = new JScrollPane(editorPane);
            frame.getContentPane().add(scrollPane);

            editorPane.setContentType("text/html");
            editorPane.setAlignmentX(100);
            editorPane.setAlignmentY(100);
            editorPane.setText(doc.html());
            editorPane.setVisible(true);
            frame.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}