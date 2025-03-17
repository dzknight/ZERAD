package stock;

import java.awt.EventQueue;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import javax.sound.*;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import javax.imageio.ImageIO;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.awt.Label;
import java.awt.PopupMenu;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import java.awt.event.KeyEvent;
import javax.swing.JList;
import java.awt.Scrollbar;

import org.eclipse.swt.dnd.Transfer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.text.ParseException;
import java.io.IOException;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import com.formdev.flatlaf.*;
import com.seaglasslookandfeel.*;
import com.seaglasslookandfeel.ui.SeaglassUI;
import mdlaf.MaterialLookAndFeel;
import newStock.StockDialog;
import newStock.StockModel;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.ScrollPane;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	//private  JButton btnRefresh;
	//현재시간 라벨
	private JLabel timeLabel;
	private JLabel dateLabel;
	public Label curTime = new Label();
	//시간 날짜 라벨 
    //개별 종목 텍스트필드
    private static String name;
    private static JTextField stock_name;
    private static  JTextField stock_code;
    public static String code;
    private static String dungRakrate;
    private static JTextField dungrak;
    private static String juga;
    private static JTextField cur_value;
    private static String geoga;
    private static JTextField low_val;
    private static String goga;
    private static JTextField high_val;
    private static String georea_val;
    private static JTextField georae;
    private static JTextField compareY;
    private static String typeComp;
    private JTextField textField;
    private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		
				try {//프레임 만들기
					View frame = new View(getParentFrame());
					DigitalClock nwFrame1=new DigitalClock();
					stock.Controller trans=new stock.Controller(null, frame);
					nwFrame1.setVisible(true);
					frame.setVisible(true);
					for(UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
						if("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							SwingUtilities.updateComponentTreeUI(frame);
							break;
						}
					}
					//기본 조회 삼성전자 고정
					/*
					*코드 순서에 따라 디스플레이 안나옴
					*/
					//주식코드의 스트링텍스트 가져오기
					trans.setInputCode(stock_code.getText());
					//stock_code.getText();
					trans.test();
					dungRakrate = trans.getDungRakrate();
					//dungrak.setText(dungRakrate);
					
					georea_val=trans.getGeoraeryang();
					georae.setText(georea_val);
					//System.out.println(georae.getText());
					name=trans.getName();
					stock_name.setText(name);
					
					juga=trans.getJuga();
					cur_value.setText(juga);
					
					goga=trans.getGoga();
					high_val.setText(goga);
					
					geoga=trans.getZeoga();
					low_val.setText(geoga);
					
					//code=trans.code;
					code=stock_code.getText();
					stock_code.setText(code);
					typeComp=trans.getStype();
					compareY.setText(typeComp);
					
				} catch (Exception  e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
	public void DigitalClock() {
		//미국시간
        setTitle("디지털 시계");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        // 시간과 날짜 레이블을 담을 패널 생성
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BorderLayout());
        
        // 시간을 표시할 레이블 생성
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Helvetica", Font.PLAIN, 60));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(Color.RED);
        
        // 날짜를 표시할 레이블 생성
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(dateLabel, BorderLayout.SOUTH);
        getContentPane().add(panel);
        
        // 1초마다 시간 갱신하는 타이머 설정
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();
        
        setVisible(true);
    }

	/**
	 * Create the frame.
	 */
	private static JFrame parentFrame;
	public View(JFrame parentFrame) {
		this.setParentFrame(parentFrame);
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					System.out.println("마우스 오른쪽 버튼 클릭");
					JPopupMenu popup=new JPopupMenu("오른쪽 버튼 메뉴");
					JMenuItem item1=new JMenuItem("아이템1");
					item1.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							System.out.println("아이템1 클릭됨");
							JOptionPane.showMessageDialog(rootPane, "아이템1 클릭됨");
						}
					});
					popup.add(item1);
					JMenuItem item2=new JMenuItem("아이템2");
					item2.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							System.out.println("아이템2 클릭됨");
							JOptionPane.showMessageDialog(rootPane, "아이템2 클릭됨");
						}
					});
					popup.add(item2);
					
					popup.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});
		//메인패널 
		getContentPane().setBackground(Color.GRAY);
		setTitle("나스닥");
		setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 14));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 640, 480);
		getContentPane().setLayout(null);
		stock_name = new JTextField();
		stock_name.setForeground(new Color(0, 0, 0));
		stock_name.setBounds(90, 83, 116, 30);
		stock_name.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		//stock_name.setText(null);
		
		getContentPane().add(stock_name);
		stock_name.setColumns(10);
		JButton btnCode = new JButton("코드 조회하기");
		btnCode.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnCode.setBounds(109, 4, 141, 40);
		getContentPane().add(btnCode);
		btnCode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StockModel model=new StockModel();
				StockDialog dialog=new StockDialog(parentFrame, model);
				dialog.setVisible(true);
			}
		});
		JButton btnNewButton = new JButton("조회");
		btnNewButton.setBounds(218, 74, 97, 30);
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

	
				//System.out.println(stock_code.getText());
				stock.Controller trans=new stock.Controller(null, null);
				trans.setInputCode(stock_code.getText());
				//stock_code.getText();
				trans.test();
				dungRakrate = trans.getDungRakrate();/*----------------------*/
				dungrak.setText(dungRakrate);
				
				georea_val=trans.getGeoraeryang();
				georae.setText(georea_val);
				
				name=trans.getName();
				stock_name.setText(name);
				
				juga=trans.getJuga(); 
				cur_value.setText(juga);
				
				goga=trans.getGoga();
				high_val.setText(goga);
				
				geoga=trans.getZeoga();
				low_val.setText(geoga);
				
				//code=trans.code;
				code=stock_code.getText();
				stock_code.setText(code);
				typeComp=trans.getStype();
				compareY.setText(typeComp);
			}
			
		});
		//https://finance.yahoo.com/
		//https://finance.naver.com/item/main.naver?code=022100
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 0, 97, 26);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"나스닥", "코스닥"}));
		comboBox.setSelectedIndex(1);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("종목");
		lblNewLabel.setBounds(33, 90, 57, 15);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		getContentPane().add(lblNewLabel);
		//새로고침 버튼 생성
		JButton btnRefresh = new JButton("새로고침");
		btnRefresh.setBounds(527, 4, 97, 40);
		btnRefresh.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		getContentPane().add(btnRefresh);
		//새로 고침 버튼 누를시 리프레시 액션 추가
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateTime();
				
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String selected=(String) comboBox.getSelectedItem();
				openWebsite(selected);
			}

			private void openWebsite(String selected) {
				// TODO Auto-generated method stub
				try {
					Desktop desktop=Desktop.getDesktop();
						switch (selected) {
						case "나스닥":
							desktop.browse(new URI("https://finance.yahoo.com/quote/%5EIXIC/"));
							break;
						case "코스닥":
							desktop.browse(new URI("https://finance.naver.com/sise/sise_index.naver?code=KPI100"));
							break;
						default:
							break;
						}
					
					} catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		Label label = new Label("현재시간");
		label.setBounds(276, 10, 69, 23);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		getContentPane().add(label);
		curTime.setBounds(361, 10, 132, 23);
		getContentPane().add(curTime);
		try {
			ImageIcon icon1=new ImageIcon("E:\\250311산출물\\참고자료\\mug.gif");
			
			
			JLabel lblNewLabel_2 = new JLabel("현재가");
			lblNewLabel_2.setBounds(33, 114, 45, 31);
			getContentPane().add(lblNewLabel_2);
			//System.out.println(dungRakrate);
			
			JLabel lblNewLabel_2_1 = new JLabel("고가");
			lblNewLabel_2_1.setBounds(33, 146, 45, 31);
			getContentPane().add(lblNewLabel_2_1);
			
			JLabel lblNewLabel_3 = new JLabel("저가");
			lblNewLabel_3.setBounds(33, 182, 57, 21);
			getContentPane().add(lblNewLabel_3);
			
			cur_value = new JTextField();
			cur_value.setForeground(Color.BLACK);
			cur_value.setEditable(false);
			cur_value.setBounds(90, 115, 116, 30);
			getContentPane().add(cur_value);
			cur_value.setText(null);
			cur_value.setColumns(10);
			
			high_val = new JTextField();
			high_val.setForeground(Color.ORANGE);
			high_val.setBounds(90, 147, 116, 30);
			getContentPane().add(high_val);
			high_val.setColumns(10);
			
			low_val = new JTextField();
			low_val.setBounds(90, 179, 116, 30);
			getContentPane().add(low_val);
			low_val.setColumns(10);
			
			JLabel lblNewLabel_3_1 = new JLabel("거래량");
			lblNewLabel_3_1.setBounds(33, 215, 57, 21);
			getContentPane().add(lblNewLabel_3_1);
			
			georae = new JTextField();
			georae.setBounds(90, 211, 116, 30);
			getContentPane().add(georae);
			georae.setColumns(10);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(403, 58, 110, 133);
			getContentPane().add(scrollPane);
			
			JList list = new JList();
			scrollPane.setViewportView(list);
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"삼성전자", "삼부토건", "포항제철", "엘지생활건강", "엔비디아", "배달의민족", "네이버", "카카오", "카카오페이", "쿠팡", "코카콜라"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			list.setSelectedIndex(0);
			
			JLabel lblNewLabel_3_1_1 = new JLabel("등락율");
			lblNewLabel_3_1_1.setBounds(33, 247, 57, 21);
			getContentPane().add(lblNewLabel_3_1_1);
			
			dungrak = new JTextField();
			dungrak.setColumns(10);
			dungrak.setBounds(90, 243, 116, 30);
			getContentPane().add(dungrak);
			
			JLabel lblNewLabel_4 = new JLabel("종목코드");
			lblNewLabel_4.setForeground(Color.BLACK);
			lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 16));
			lblNewLabel_4.setBackground(Color.WHITE);
			lblNewLabel_4.setBounds(12, 57, 78, 15);
			getContentPane().add(lblNewLabel_4);
			
			stock_code = new JTextField("005930");
			stock_code.setForeground(Color.RED);
			stock_code.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			stock_code.setColumns(10);
			stock_code.setBounds(90, 51, 116, 30);
			getContentPane().add(stock_code);
			
			JLabel compare = new JLabel("어제대비");
			compare.setBounds(33, 279, 57, 21);
			getContentPane().add(compare);
			
			compareY = new JTextField();
			compareY.setColumns(10);
			compareY.setBounds(90, 275, 116, 30);
			getContentPane().add(compareY);
			
			JButton btnSave = new JButton("저장");
			btnSave.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			btnSave.setBounds(217, 114, 97, 30);
			getContentPane().add(btnSave);
			
			JInternalFrame internalFrame = new JInternalFrame("종목코드조회");
			internalFrame.setBounds(234, 215, 331, 226);
			getContentPane().add(internalFrame);
			internalFrame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("종목명");
			lblNewLabel_1.setBounds(12, 10, 57, 15);
			internalFrame.getContentPane().add(lblNewLabel_1);
			
			textField = new JTextField();
			textField.setBounds(81, 7, 116, 21);
			internalFrame.getContentPane().add(textField);
			textField.setColumns(10);
			
			JButton btnNewButton_1 = new JButton("조회");
			btnNewButton_1.setBounds(211, 6, 79, 23);
			internalFrame.getContentPane().add(btnNewButton_1);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					"\uC885\uBAA9\uCF54\uB4DC", "\uC885\uBAA9\uBA85"
				}
			));
			table.setBounds(22, 38, 265, 148);
			internalFrame.getContentPane().add(table);
			internalFrame.setVisible(true);
			

			
			//라벨에 현재 시간 제이프레임 띄울때 시간 디스플레이	
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		updateTime();
		
		
	}
	//라벨을 현재시간으로 갱신하는 메서드
	private void updateTime() {
		// TODO Auto-generated method stub
		String currentTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm;ss"));
		curTime.setText(currentTime);
		
		
	}
	//라벨을 현재시간으로 갱신하는 메서드
	/*
	private void updateTimeNy() {
		// TODO Auto-generated method stub
		TimeZone newyork=TimeZone.getTimeZone("America/New_York");
		
		Calendar calendar=Calendar.getInstance(newyork);
		SimpleDateFormat timeFormater=new SimpleDateFormat("hh:mm:ss");
		timeFormater.setTimeZone(newyork);
		//String currentTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm;ss"));
		String time=timeFormater.format(calendar.getTime());
		timeLabel.setText(time);
		//curTime.setText(currentTime);
        // 날짜 형식 지정
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        //String currentTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm;ss"));
        dateFormatter.setTimeZone(newyork);
        String date = dateFormatter.format(calendar.getTime());
        dateLabel.setText(date);
		
		
	}
	*/
//팝업 이벤트
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					popup.show(e.getComponent(),e.getX(),e.getY());
				}
			}
			
		});
	}


	public static JFrame getParentFrame() {
		return parentFrame;
	}


	public static void setParentFrame(JFrame parentFrame) {
		View.parentFrame = parentFrame;
	}
}
