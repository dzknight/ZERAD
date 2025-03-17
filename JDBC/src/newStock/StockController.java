package newStock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class StockController {
    private StockModel model;
    private StockView view;
    
    public StockController(StockModel model, StockView view) {
        this.model = model;
        this.view = view;
        
        // View에 Model의 데이터 설정
        this.view.setTableModel(model.getTableModel());
        this.view.setStockList(model.getStockList());
        
        // 이벤트 리스너 등록
        this.view.addRefreshButtonListener(new RefreshButtonListener());
    }
    
    class RefreshButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 데이터 새로고침
            model.loadDataFromDatabase();
            
            // View 업데이트
            view.setStockList(model.getStockList());
        }
    }
    
    public void start() {
        SwingUtilities.invokeLater(() -> {
           view.setVisible(true);
        });
    }
}