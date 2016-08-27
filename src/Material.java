import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Material extends javax.swing.JPanel {

	private Properties prop;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String materialNum;
	private String materialName;
	private int qty;
	private String vendorNum;
	private String note;
	
    public Material() {
        initComponents();
        setDBProp();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	  jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          jLabel7 = new javax.swing.JLabel();
          jLabel10 = new javax.swing.JLabel();
          jScrollPane1 = new javax.swing.JScrollPane();
          txtNote = new javax.swing.JEditorPane();
          txtMaterialName = new javax.swing.JTextField();
          jLabel11 = new javax.swing.JLabel();
          spQty = new javax.swing.JSpinner();
          txtVendorNum = new javax.swing.JTextField();
          jLabel3 = new javax.swing.JLabel();
          lbMaterialNum = new javax.swing.JLabel();

          setPreferredSize(new java.awt.Dimension(980, 470));

          jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
          jLabel1.setText("原料編號");

          jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
          jLabel2.setText("數量");

          jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N

          jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
          jLabel10.setText("備註");

          jScrollPane1.setViewportView(txtNote);

          txtMaterialName.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

          jLabel11.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
          jLabel11.setText("進貨廠商編號");

          spQty.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

          txtVendorNum.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
          txtVendorNum.addKeyListener(new java.awt.event.KeyAdapter() {
              public void keyReleased(java.awt.event.KeyEvent evt) {
                  txtVendorNumKeyReleased(evt);
              }
          });

          jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
          jLabel3.setText("原料名稱");

          lbMaterialNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
          lbMaterialNum.setText("");

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
          this.setLayout(layout);
          layout.setHorizontalGroup(
              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addGap(59, 59, 59)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                      .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                      .addGroup(layout.createSequentialGroup()
                          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addGap(0, 0, Short.MAX_VALUE)))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                      .addComponent(txtMaterialName, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                      .addComponent(spQty, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(lbMaterialNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addGap(56, 56, 56)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                      .addGroup(layout.createSequentialGroup()
                          .addComponent(jLabel11)
                          .addGap(32, 32, 32)
                          .addComponent(txtVendorNum, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGroup(layout.createSequentialGroup()
                          .addComponent(jLabel10)
                          .addGap(90, 90, 90)
                          .addComponent(jLabel7)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                          .addComponent(jScrollPane1)))
                  .addGap(746, 746, 746))
          );
          layout.setVerticalGroup(
              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addGap(62, 62, 62)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(jLabel1)
                      .addComponent(jLabel11)
                      .addComponent(txtVendorNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(lbMaterialNum, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                  .addGap(0, 0, Short.MAX_VALUE)
                                  .addComponent(jLabel7)
                                  .addGap(24, 24, 24))
                              .addGroup(layout.createSequentialGroup()
                                  .addGap(18, 18, 18)
                                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                      .addComponent(jLabel3)
                                      .addComponent(txtMaterialName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                      .addComponent(jLabel10))
                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(jLabel2)
                              .addComponent(spQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addGap(331, 331, 331))
                      .addGroup(layout.createSequentialGroup()
                          .addGap(18, 18, 18)
                          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
          );
    }// </editor-fold>                        
    
    private void setDBProp() {

		prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "");
		prop.setProperty("characterEncoding", "UTF-8");
		prop.setProperty("useUnicode", "true");
		prop.setProperty("useSSL", "False");
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/erp", prop);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    protected void setInputValue(HashMap<Integer, String> data) {
    	lbMaterialNum.setText(data.get(0));
    	txtMaterialName.setText(data.get(1));
    	spQty.setValue(Integer.parseInt(data.get(2)));
    	txtVendorNum.setText(data.get(3));
    	txtNote.setText(data.get(4));
    }
    
    protected void clearInput() {
    	txtMaterialName.setText("");
    	lbMaterialNum.setText("");
    	spQty.setValue(0);
    	txtVendorNum.setText("");
    	txtNote.setText("");
    }
    private boolean getUserInputParm() {
    	boolean isRightData = false;
    	materialName = txtMaterialName.getText();
    	qty = (Integer)spQty.getValue();
    	vendorNum = txtVendorNum.getText();
    	note = txtNote.getText();
    	if(materialName.equals("")||qty<=0||vendorNum.equals("")){
    		isRightData = false;
    	}
    	else{
    		isRightData = true;
    	}
    	return isRightData;
    }
    
    protected int insertData() {
		int isInsert = 0;
		if(getUserInputParm() == true){
			try {
				pstmt = con.prepareStatement("INSERT INTO material(materialName,qty,vendorNum,note)VALUES(?,?,?,?)");
				pstmt.setString(1, materialName);
				pstmt.setString(2, Integer.toString(qty));
				pstmt.setString(3, vendorNum);
				pstmt.setString(4, note);
				isInsert = pstmt.executeUpdate();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		return isInsert;
    }
    
    protected int updateData() {
    	int isUpdate = 0;
    	materialNum = lbMaterialNum.getText();
    	if (getUserInputParm() == true && !materialNum.equals("")) {
    		try {
				pstmt = con.prepareStatement("UPDATE material SET materialName=?,qty=?,vendorNum=?,note=? WHERE materialNum = ?");
				pstmt.setString(1, materialName);
				pstmt.setString(2, Integer.toString(qty));
				pstmt.setString(3, vendorNum);
				pstmt.setString(4, note);
				pstmt.setString(5, materialNum);
				isUpdate = pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
    		
    	}
    	return isUpdate;
    }
    
    protected int delData(){
    	int isDel = 0;
    	materialNum = lbMaterialNum.getText();
    	if(!materialNum.equals("")){
    		try{
    			pstmt = con.prepareStatement("DELETE FROM material WHERE materialNum=?");
    			pstmt.setString(1, materialNum);
    			isDel = pstmt.executeUpdate();
    		}
    		catch(SQLException ee){
    			System.out.println(ee.toString());
    		}
    	}
    	return isDel;
    }
    
    protected LinkedList<String[]> queryData() {
		LinkedList<String[]> data = new LinkedList<>();
		try{
			pstmt = con.prepareStatement("SELECT * FROM material");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[5];
				row[0] = rs.getString("materialNum");
				row[1] = rs.getString("materialName");
				row[2] = rs.getString("qty");
				row[3] = rs.getString("vendorNum");
				row[4] = rs.getString("note");
				data.add(row);
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return data;
    }
    
    protected  LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try{
			pstmt = con.prepareStatement("SELECT * FROM material WHERE materialNum LIKE ? OR materialName LIKE ? OR qty LIKE ? OR vendorNum LIKE ? OR note LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<6; i++){
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[5];
				row[0] = rs.getString("materialNum");
				row[1] = rs.getString("materialName");
				row[2] = rs.getString("qty");
				row[3] = rs.getString("vendorNum");
				row[4] = rs.getString("note");
				data.add(row);
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return data;
    }
    
    private void txtVendorNumKeyReleased(java.awt.event.KeyEvent evt) {                                         
        String vendorNum = "";
        try {
			pstmt = con.prepareStatement("SELECT vendorNum FROM vendor Where vendorNum = ?");
			pstmt.setString(1, txtVendorNum.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vendorNum = rs.getString("vendorNum");
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		if (vendorNum.equals("")) {
			JOptionPane.showMessageDialog(txtVendorNum, "查無此廠商");
		}
    }       
    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMaterialNum;
    private javax.swing.JSpinner spQty;
    private javax.swing.JTextField txtMaterialName;
    private javax.swing.JEditorPane txtNote;
    private javax.swing.JTextField txtVendorNum;
    // End of variables declaration                   
}
