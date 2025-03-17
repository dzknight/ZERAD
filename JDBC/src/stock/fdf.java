package stock;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class fdf {

	    public static void main(String[] args) throws IOException {
	        File file = new File("E:\\\\250311산출물\\\\참고자료\\\\maven.png");
	        BufferedImage img = ImageIO.read(file);
	        JLabel lb = new JLabel(new ImageIcon(img));
	        JFrame f = new JFrame("이미지 그리기");
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.getContentPane().add(lb);
	        f.pack();
	        f.setLocation(200,200);
	        f.setVisible(true);
	    }
	}