package stock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RightClickExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Right Click Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 300));

        // 마우스 리스너 추가
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // 마우스 오른쪽 버튼을 눌렀는지 확인
                if (SwingUtilities.isRightMouseButton(e)) {
                    System.out.println("Right mouse button pressed");
                    
                    // 팝업 메뉴 표시
                    JPopupMenu popupMenu = new JPopupMenu("Right Click Menu");
                    popupMenu.add("Item 1");
                    popupMenu.add("Item 2");
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}