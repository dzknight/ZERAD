package newStock;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class StockView extends JPanel {
    private JList<String> stockJList;
    private JTable stockTable;
    private JButton refreshButton;
    private DefaultListModel<String> listModel;
    
    public StockView() {

        setLayout(new BorderLayout());
        
        // JList 초기화
        listModel = new DefaultListModel<>();
        stockJList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(stockJList);
        
        // JTable 초기화
        stockTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(stockTable);
        
        // 버튼 패널
        JPanel buttonPanel = new JPanel();
        refreshButton = new JButton("새로고침");
        buttonPanel.add(refreshButton);
        
        // 레이아웃 구성
        JSplitPane splitPane = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT, listScrollPane, tableScrollPane);
        splitPane.setDividerLocation(200);
        
        add(splitPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void setStockList(java.util.List<String> stocks) {
        listModel.clear();
        for (String stock : stocks) {
            listModel.addElement(stock);
        }
    }
    
    public void setTableModel(javax.swing.table.DefaultTableModel model) {
        stockTable.setModel(model);
    }
    
    public void addRefreshButtonListener(ActionListener listener) {
        refreshButton.addActionListener(listener);
    }
    
    public JList<String> getStockJList() {
        return stockJList;
    }
}