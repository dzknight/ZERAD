package tryTest;

import java.awt.EventQueue;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.Timer;

import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.awt.Label;
import java.util.Calendar;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class WbTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private final Action action = new SwingAction();
	private JTextField textField;
	private final Action action_1 = new SwingAction_1();
	//private  JButton btnRefresh;
	//현재시간 라벨
	public Label curTime = new Label();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WbTest frame = new WbTest();
					frame.setVisible(true);
				} catch (Exception  e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WbTest() {
		getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_F5) {
					//입력시 발생 이벤트
				}
			}
		});
		getContentPane().setBackground(Color.GRAY);
		setTitle("나스닥");
		setFont(new Font("Helvetica", Font.PLAIN, 14));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		Timer timer=new Timer(1000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Calendar calendar=Calendar.getInstance();
					int hour=calendar.get(Calendar.HOUR_OF_DAY);
					int min=calendar.get(Calendar.MINUTE);
					int sec=calendar.get(Calendar.SECOND);
					curTime.setText("현재"+hour+"시"+min+"분"+sec+"초");
				}
		});
		timer.start();
		setVisible(true);
		getContentPane().setLayout(null);
		textField = new JTextField();
		textField.setBounds(90, 79, 116, 21);
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textField.setText("삼성전자");
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("조회");
		btnNewButton.setBounds(218, 78, 97, 23);
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton.setAction(action_1);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String url="https://finance.naver.com/item/main.naver?code=022100";
				//클릭시 네이버 주식페이지 오픈 이벤트
				try {
					Desktop.getDesktop().browse(new URI(url));
				}  catch(IOException | URISyntaxException ex){//exception2ro 사용
					JOptionPane.showConfirmDialog(btnNewButton, ex.getMessage());//
				}
			}
		});
		//https://finance.yahoo.com/
		//https://finance.naver.com/item/main.naver?code=022100
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 10, 97, 38);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"나스닥", "코스닥"}));
		comboBox.setSelectedIndex(1);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("종목");
		lblNewLabel.setBounds(33, 82, 57, 15);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("주식 정보 디스플레이 ");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\250311산출물\\참고자료\\maven.png"));
		lblNewLabel_1.setBounds(12, 40, 574, 450);
		getContentPane().add(lblNewLabel_1);
		//새로고침 버튼 생성
		JButton btnRefresh = new JButton("새로고침");
		btnRefresh.setBounds(499, 10, 97, 23);
		getContentPane().add(btnRefresh);
		//새로 고침 버튼 누를시 리프레시 액션 추가
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateLabel();
			}
		});
		
		Label label = new Label("현재시간");
		label.setBounds(276, 10, 69, 23);
		getContentPane().add(label);
		//현재 시간 표시할 라벨
		
		

		Label curTime = new Label();
		curTime.setBounds(361, 10, 132, 23);
		getContentPane().add(curTime);
		
		updateLabel();
		
		
	}
	//라벨을 현재시간으로 갱신하는 메서드
	private void updateLabel() {
		// TODO Auto-generated method stub
		String currentTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm;ss"));
		curTime.setText(currentTime);
		
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(LARGE_ICON_KEY, null);
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
