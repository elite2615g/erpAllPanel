
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 許哲浩
 */
public class OrderList extends javax.swing.JPanel {
    private Connection conn;
	private Properties prop;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
    
    public OrderList() {
        initComponents();
        setDBProp();
    }
    
	private void setDBProp() {

		prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "");
		prop.setProperty("characterEncoding", "UTF-8");
		prop.setProperty("useUnicode", "true");
		prop.setProperty("useSSL", "False");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/erp", prop);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//判斷input有無空白
	private boolean getUserInputParm() {
		boolean isRightData = false;
		if (text_orderNum.getText().equals("") 
				|| text_customerId.getText().equals("")
				|| ((JTextField) date_orderDate.getDateEditor().getUiComponent()).getText().equals("")
				|| text_status.getText().equals("")
				|| text_dispatch.getText().equals("")
				|| text_note.getText().equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
	}
    
    protected int insertData(){
    	int isInsert = 0;	//紀錄資料有沒有insert成功
        java.util.Date date = date_orderDate.getDate();        
        String strDate =DateFormat.getDateInstance().format(date);      
        try{
            pstmt = conn.prepareStatement(
                    "INSERT INTO orderlist(orderNum,customerId,orderDate,status,dispatch,note) VALUES('"
                            + ""+text_orderNum.getText()+"','"
                            + ""+text_customerId.getText()+"','"
                            + ""+strDate+"','"
                            + ""+text_status.getText()+"','"
                            + ""+text_dispatch.getText()+"','"
                            + ""+text_note.getText()+"')");
            isInsert = pstmt.executeUpdate();
            

            
            pstmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return isInsert;
    }

	protected int delData(){
		int isDel = 0;
		if(!text_orderNum.getText().equals("")){
			try{
				pstmt = conn.prepareStatement("DELETE FROM orderList WHERE orderNum = ?");
				pstmt.setString(1, text_orderNum.getText());
				isDel = pstmt.executeUpdate();
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
		}
		
		return isDel;
	}
    
	protected int updateData() {
		String strOrderNum = text_orderNum.getText();
        java.util.Date date = date_orderDate.getDate();        
        String strDate =DateFormat.getDateInstance().format(date);      
		int isUpdate = 0;
		if (getUserInputParm() == true) {
			try {
				pstmt = conn.prepareStatement(
						"UPDATE orderList SET customerId=?,orderDate=?,status=?,dispatch=?,note=? WHERE orderNum = ?" );
				pstmt.setString(1, text_customerId.getText());
				pstmt.setString(2, strDate);
				pstmt.setString(3, text_status.getText());
				pstmt.setString(4, text_dispatch.getText());
				pstmt.setString(5, text_note.getText());
				pstmt.setString(6, strOrderNum);
				isUpdate = pstmt.executeUpdate();
				
				
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		return isUpdate;
	}
    
    protected LinkedList<String[]> queryData(){
    	 LinkedList<String[]> rows = new LinkedList<String[]>();
        try{
            pstmt = conn.prepareStatement("SELECT * FROM orderlist");
            rs =  pstmt.executeQuery();

            while(rs.next()){
                String[] row = new String[6];
                row[0] = rs.getString("orderNum");
                row[1] = rs.getString("customerId");
                row[2] = rs.getString("orderDate");
                row[3] = rs.getString("status");
                row[4] = rs.getString("dispatch");
                row[5] = rs.getString("note");

                rows.add(row);
            }

            pstmt.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return rows;
    }
    
    protected String[] getColumn(){ 
        String[] columnName = 
                new String[]{"orderNum","customerId","orderDate","status","dispatch","note"};
        return columnName;
    }
    
    protected void clearInput(){
        text_orderNum.setText("");
        text_customerId.setText("");
        date_orderDate.setDate(null);
        text_status.setText("");
        text_dispatch.setText("");        
        text_note.setText("");
    }

	protected  LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM orderlist WHERE orderNum LIKE ? OR customerId LIKE? "
					+ "OR orderDate LIKE ? OR status LIKE ? OR dispatch LIKE ? OR note LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<7; i++){
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[6];
				row[0] = rs.getString("orderNum");
				row[1] = rs.getString("customerId");
				row[2] = rs.getString("orderDate");
				row[3] = rs.getString("status");
				row[4] = rs.getString("dispatch");
				row[5] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			ee.toString();
		}
		return data;
	}  
    
    
    
	protected void setInputValue(HashMap<Integer, String> data) {
		
		
		text_orderNum.setText(data.get(0));
		text_customerId.setText(data.get(1));
		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(data.get(2));
			date_orderDate.setDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		text_status.setText(data.get(3));	
		text_dispatch.setText(data.get(4));
		text_note.setText(data.get(5));
	}
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_orderNum = new javax.swing.JLabel();
        label_customerId = new javax.swing.JLabel();
        label_orderDate = new javax.swing.JLabel();
        label_status = new javax.swing.JLabel();
        label_dispatch = new javax.swing.JLabel();
        label_note = new javax.swing.JLabel();
        text_orderNum = new javax.swing.JTextField();
        text_status = new javax.swing.JTextField();
        text_dispatch = new javax.swing.JTextField();
        text_customerId = new javax.swing.JTextField();
        date_orderDate = new com.toedter.calendar.JDateChooser();
        scroll_note = new javax.swing.JScrollPane();
        text_note = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(980, 470));
        setPreferredSize(new java.awt.Dimension(980, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_orderNum.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_orderNum.setText("訂單編號");
        add(label_orderNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        label_customerId.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_customerId.setText("客戶編號");
        add(label_customerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, -1));

        label_orderDate.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_orderDate.setText("下單日期");
        add(label_orderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 20));

        label_status.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_status.setText("狀態");
        add(label_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, -1));

        label_dispatch.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_dispatch.setText("配送方式");
        add(label_dispatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        label_note.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_note.setText("備註");
        add(label_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        text_orderNum.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        add(text_orderNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 150, 25));

        text_status.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        add(text_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 150, 25));

        text_dispatch.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        add(text_dispatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 150, 25));

        text_customerId.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        add(text_customerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 150, 25));

        date_orderDate.setDateFormatString("yyyy/M/d h:m:s");
        add(date_orderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 180, 25));

        text_note.setColumns(20);
        text_note.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        text_note.setRows(5);
        scroll_note.setViewportView(text_note);

        add(scroll_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date_orderDate;
    private javax.swing.JLabel label_customerId;
    private javax.swing.JLabel label_dispatch;
    private javax.swing.JLabel label_note;
    private javax.swing.JLabel label_orderDate;
    private javax.swing.JLabel label_orderNum;
    private javax.swing.JLabel label_status;
    private javax.swing.JScrollPane scroll_note;
    private javax.swing.JTextField text_customerId;
    private javax.swing.JTextField text_dispatch;
    private javax.swing.JTextArea text_note;
    private javax.swing.JTextField text_orderNum;
    private javax.swing.JTextField text_status;
    // End of variables declaration//GEN-END:variables
}
