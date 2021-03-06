import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import javax.swing.JOptionPane;

public class PayRoll extends javax.swing.JPanel {

	private Properties prop;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String employeeNum;
	private String payRoll;
	private String note;

	public PayRoll() {
		initComponents();
		setDBProp();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		bgGender = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtNote = new javax.swing.JEditorPane();
		txtPay = new javax.swing.JFormattedTextField();
		txtEmpoyeeNum = new javax.swing.JFormattedTextField();

		setPreferredSize(new java.awt.Dimension(980, 470));

		jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
		jLabel1.setText("員工編號");

		jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
		jLabel2.setText("薪資");

		jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N

		jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
		jLabel10.setText("備註");

		txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
		jScrollPane1.setViewportView(txtNote);

		txtPay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
		txtPay.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

		txtEmpoyeeNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
		txtEmpoyeeNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
		txtEmpoyeeNum.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtEmpoyeeNumKeyReleased(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(59, 59, 59)
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(
										jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(376, 376, 376).addComponent(jLabel7))
								.addGroup(layout.createSequentialGroup().addGap(28, 28, 28)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(txtPay, javax.swing.GroupLayout.DEFAULT_SIZE, 225,
														Short.MAX_VALUE)
												.addComponent(txtEmpoyeeNum))
										.addGap(78, 78, 78).addComponent(jLabel10).addGap(18, 18, 18)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(314, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(62, 62, 62)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1).addComponent(jLabel10))
										.addComponent(txtEmpoyeeNum, javax.swing.GroupLayout.DEFAULT_SIZE, 31,
												Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtPay, javax.swing.GroupLayout.DEFAULT_SIZE, 30,
												Short.MAX_VALUE)))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel7).addGap(311, 311, 311)));
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
		txtEmpoyeeNum.setText(data.get(0));
		txtPay.setText(data.get(1));
		txtNote.setText(data.get(2));
	}

	private boolean getUserInputParm() {
		boolean isRightData = false;
		employeeNum = txtEmpoyeeNum.getText();
		payRoll = txtPay.getText();
		note = txtNote.getText();
		if (employeeNum.equals("") || payRoll.equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		
		return isRightData;
	}

	protected void clearInput() {
		txtEmpoyeeNum.setText("");
		txtPay.setText("");
		txtNote.setText("");
	}

	protected int insertData() {
		int isInsert = 0;
		if(getUserInputParm() == true){
			try {
				pstmt = con.prepareStatement("INSERT INTO payroll(employeeNum,pay,note)VALUES(?,?,?)");
				pstmt.setString(1, employeeNum);
				pstmt.setString(2, payRoll);
				pstmt.setString(3, note);
				isInsert = pstmt.executeUpdate();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		
		return isInsert;
	}
	
	protected int updateData() {
    	int isUpdate = 0;
    	if (getUserInputParm() == true) {
    		try{
    			pstmt = con.prepareStatement("UPDATE payroll SET pay=?,note=? WHERE employeeNum = ?" );
    			pstmt.setString(1, payRoll);
    			pstmt.setString(2, note);
    			pstmt.setString(3, employeeNum);
    			isUpdate = pstmt.executeUpdate();
    		}
    		catch(SQLException ee){
    			System.out.println(ee.toString());
    		}
    	}
    	return isUpdate;
	}
	
	protected int delData(){
    	int isDel = 0;
    	employeeNum = txtEmpoyeeNum.getText();
    	if(!employeeNum.equals("")){
    		try{
    			pstmt = con.prepareStatement("DELETE FROM payroll WHERE employeeNum=?");
    			pstmt.setString(1, employeeNum);
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
		try {
			pstmt = con.prepareStatement("SELECT * FROM payRoll");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[3];
				row[0] = rs.getString("employeeNum");
				row[1] = rs.getString("pay");
				row[2] = rs.getString("note");
				data.add(row);
			}

		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}
	
	protected  LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try{
			pstmt = con.prepareStatement("SELECT * FROM payroll WHERE employeeNum LIKE ? OR pay LIKE ? OR note LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<4; i++){
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[3];
				row[0] = rs.getString("employeeNum");
				row[1] = rs.getString("pay");
				row[2] = rs.getString("note");
				data.add(row);
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return data;
	}
	
	private void txtEmpoyeeNumKeyReleased(java.awt.event.KeyEvent evt) {
		String employeeNum = "";
		try {
			pstmt = con.prepareStatement("SELECT employeeNum FROM employee Where employeeNum = ?");
			pstmt.setString(1, txtEmpoyeeNum.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				employeeNum = rs.getString("employeeNum");
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		if (employeeNum.equals("")) {
			JOptionPane.showMessageDialog(txtEmpoyeeNum, "查無此員工");
		}
	}

	// Variables declaration - do not modify
	private javax.swing.ButtonGroup bgGender;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JFormattedTextField txtEmpoyeeNum;
	private javax.swing.JEditorPane txtNote;
	private javax.swing.JFormattedTextField txtPay;
	// End of variables declaration
}
