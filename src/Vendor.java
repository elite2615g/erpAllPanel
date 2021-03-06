
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 許哲浩
 */
public class Vendor extends javax.swing.JPanel {
    private Connection conn;
	private Properties prop;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

    public Vendor() {
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
		if (text_vendorName.getText().equals("") 
				|| text_vendorTel.getText().equals("")
				|| text_vendorAddr.getText().equals("")
				|| text_taxId.getText().equals("")
				|| text_contactPerson.getText().equals("")
				|| text_paymentTerm.getText().equals("")
				|| text_note.getText().equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
	}
    
    protected int insertData(){
    	
    	int isInsert = 0;	
        try{
            pstmt = conn.prepareStatement(
                    "INSERT INTO vendor(vendorName,tel,address,taxId,contactPerson,paymentTerm,note) VALUES('"
                            + ""+text_vendorName.getText()+"','"
                            + ""+text_vendorTel.getText()+"','"
                            + ""+text_vendorAddr.getText()+"','"
                            + ""+text_taxId.getText()+"','"
                            + ""+text_contactPerson.getText()+"','"
                            + ""+text_paymentTerm.getText()+"','"
                            + ""+text_note.getText()+"')");
            isInsert = pstmt.executeUpdate();
       
            pstmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return isInsert;
    }
    
    //增加一欄位紀錄id
	protected int delData(){
		int isDel = 0;
		if(!text_vendorName.getText().equals("")){
			try{
				pstmt = conn.prepareStatement("DELETE FROM vendor WHERE text_vendorName = ?");
				pstmt.setString(1, text_vendorName.getText());
				isDel = pstmt.executeUpdate();
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
		}
		
		return isDel;
	}
    
	protected int updateData() {
		String strVendorName = text_vendorName.getText();
		int isUpdate = 0;
		if (getUserInputParm() == true) {
			try {
				pstmt = conn.prepareStatement(
						"UPDATE issue SET tel=?,address=?,taxId=?,contactPerson=?,paymentTerm=?,note=? WHERE vendorName=?" );
				pstmt.setString(1, text_vendorTel.getText());
				pstmt.setString(2, text_vendorAddr.getText());
				pstmt.setString(3, text_taxId.getText());
				pstmt.setString(4, text_contactPerson.getText());
				pstmt.setString(5, text_paymentTerm.getText());
				pstmt.setString(6, text_note.getText());
				pstmt.setString(7, strVendorName);
				
				
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
            pstmt = conn.prepareStatement("SELECT * FROM vendor");
            rs =  pstmt.executeQuery();

            
            while(rs.next()){
                String[] row = new String[8];
                row[0] = rs.getString("vendorNum");
                row[1] = rs.getString("vendorName");
                row[2] = rs.getString("tel");
                row[3] = rs.getString("address");
                row[4] = rs.getString("taxId");
                row[5] = rs.getString("contactPerson");
                row[6] = rs.getString("paymentTerm");
                row[7] = rs.getString("note");

                rows.add(row);
            }

            pstmt.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return rows;
    }
    
	protected  LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM vendor WHERE vendorName LIKE ? OR tel LIKE?"
					+ " OR address LIKE ?  OR taxId LIKE ?  OR contactPerson LIKE ?  "
					+ "OR paymentTerm LIKE ? OR note LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<8; i++){
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[7];
				row[0] = rs.getString("vendorName");
				row[1] = rs.getString("tel");
				row[2] = rs.getString("address");
				row[3] = rs.getString("taxId");
				row[4] = rs.getString("contactPerson");
				row[5] = rs.getString("paymentTerm");
				row[6] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			ee.toString();
		}
		return data;
	}
    
    
    protected String[] getColumn(){ 
        String[] columnName = 
                new String[]{"vendorNum","vendorName","tel","address","taxId","contactPerson","paymentTerm","note"};
        return columnName;
    }
    
    
	protected void setInputValue(HashMap<Integer, String> data) {
		text_vendorName.setText(data.get(1));
		text_vendorTel.setText(data.get(2));
		text_vendorAddr.setText(data.get(3));	
		text_taxId.setText(data.get(4));	
		text_contactPerson.setText(data.get(5));	
		text_paymentTerm.setText(data.get(6));			
		text_note.setText(data.get(7));
	}
	
    
    
	protected void clearInput(){
        text_vendorName.setText("");
        text_vendorTel.setText("");
        text_vendorAddr.setText("");
        text_taxId.setText("");
        text_contactPerson.setText("");
        text_paymentTerm.setText("");
        
        text_note.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        label_vendorNum = new javax.swing.JLabel();
        label_vendorTel = new javax.swing.JLabel();
        label_vendorAddr = new javax.swing.JLabel();
        label_taxId = new javax.swing.JLabel();
        label_contactPerson = new javax.swing.JLabel();
        label_paymentTerm = new javax.swing.JLabel();
        label_note = new javax.swing.JLabel();
        text_vendorName = new javax.swing.JTextField();
        text_vendorTel = new javax.swing.JTextField();
        text_vendorAddr = new javax.swing.JTextField();
        text_taxId = new javax.swing.JTextField();
        text_contactPerson = new javax.swing.JTextField();
        text_paymentTerm = new javax.swing.JTextField();
        scroll_note = new javax.swing.JScrollPane();
        text_note = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(980, 470));
        setPreferredSize(new java.awt.Dimension(980, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_vendorNum.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_vendorNum.setText("廠商名稱");
        add(label_vendorNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        label_vendorTel.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_vendorTel.setText("廠商電話");
        add(label_vendorTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, -1));

        label_vendorAddr.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_vendorAddr.setText("廠商地址");
        add(label_vendorAddr, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 20));

        label_taxId.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_taxId.setText("統編");
        add(label_taxId, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, -1));

        label_contactPerson.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_contactPerson.setText("聯絡人");
        add(label_contactPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        label_paymentTerm.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_paymentTerm.setText("付款條件");
        add(label_paymentTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, -1, 20));

        label_note.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        label_note.setText("備註");
        add(label_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        text_vendorName.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        add(text_vendorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 150, 25));

        text_vendorTel.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        add(text_vendorTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 150, 25));

        text_vendorAddr.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        add(text_vendorAddr, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 150, 25));

        text_taxId.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        add(text_taxId, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 150, 25));

        text_contactPerson.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        add(text_contactPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 150, 25));

        text_paymentTerm.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        add(text_paymentTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 150, 25));

        text_note.setColumns(20);
        text_note.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        text_note.setRows(5);
        scroll_note.setViewportView(text_note);

        add(scroll_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label_contactPerson;
    private javax.swing.JLabel label_note;
    private javax.swing.JLabel label_paymentTerm;
    private javax.swing.JLabel label_taxId;
    private javax.swing.JLabel label_vendorAddr;
    private javax.swing.JLabel label_vendorNum;
    private javax.swing.JLabel label_vendorTel;
    private javax.swing.JScrollPane scroll_note;
    private javax.swing.JTextField text_contactPerson;
    private javax.swing.JTextArea text_note;
    private javax.swing.JTextField text_paymentTerm;
    private javax.swing.JTextField text_taxId;
    private javax.swing.JTextField text_vendorAddr;
    private javax.swing.JTextField text_vendorName;
    private javax.swing.JTextField text_vendorTel;
    // End of variables declaration//GEN-END:variables
}
