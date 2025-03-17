package stock;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OpenWebsiteExample {
	public static void main(String[] args) {
        JFrame frame = new JFrame("웹사이트 열기 예제");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton button = new JButton("웹사이트 열기");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "https://www.google.com"; // 원하는 URL로 변경 가능
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (IOException | URISyntaxException ex) {
                    JOptionPane.showMessageDialog(frame, "브라우저를 여는 중 오류가 발생했습니다: " + ex.getMessage());
                }
            }
        });

        frame.add(button);
        frame.setLocationRelativeTo(null); // 화면 중앙에 표시
        frame.setVisible(true);
    }
}