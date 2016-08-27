import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elite2615
 */
public class Product extends javax.swing.JPanel {
	private String productNum;
	private String productName;
	private String price;
	private String category;
	private String note;
	private Properties prop;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/**
	 * Creates new form product
	 */
	public Product() {
		initComponents();
		setDBProp();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		label_productNum = new javax.swing.JLabel();
		label_productName = new javax.swing.JLabel();
		label_price = new javax.swing.JLabel();
		label_category = new javax.swing.JLabel();
		label_note = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		text_note = new javax.swing.JTextArea();
		text_productNum = new javax.swing.JTextField();
		text_productName = new javax.swing.JTextField();
		text_price = new javax.swing.JTextField();
		text_category = new javax.swing.JTextField();
		dateChooser = new com.toedter.calendar.JDateChooser();
		label_dateTest = new javax.swing.JLabel();
		setPreferredSize(new java.awt.Dimension(980, 470));

		label_productNum.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
		label_productNum.setText("產品編號");

		label_productName.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
		label_productName.setText("品名");

		label_price.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
		label_price.setText("單價");

		label_category.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
		label_category.setText("類別");

		label_note.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
		label_note.setText("備註");
		label_note.setToolTipText("");

		text_note.setColumns(20);
		text_note.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
		text_note.setRows(5);
		jScrollPane2.setViewportView(text_note);

		text_productNum.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

		text_productName.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

		text_price.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

		text_category.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

		label_dateTest.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
		label_dateTest.setText("日期測試");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(66, 66, 66).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(layout.createSequentialGroup().addComponent(label_category)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(text_category, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addComponent(label_price)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(text_price, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addComponent(label_productName)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(text_productName, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(
										layout.createSequentialGroup().addComponent(label_productNum).addGap(18, 18, 18)
												.addComponent(text_productNum, javax.swing.GroupLayout.PREFERRED_SIZE,
														150, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(
								layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(label_note).addComponent(label_dateTest))
										.addGap(34, 34, 34)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(424, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(51, 51, 51)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(label_productNum).addComponent(text_productNum,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(13, 13, 13)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(label_productName).addComponent(text_productName,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(label_price).addComponent(text_price,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(13, 13, 13)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(label_category).addComponent(text_category,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(13, 13, 13).addComponent(label_note))
								.addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(jScrollPane2,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(label_dateTest))
						.addContainerGap(124, Short.MAX_VALUE)));
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
    	label_productNum.setText(data.get(0));
    	text_productName.setText(data.get(1));
    	text_price.setText((data.get(2)));
    	text_category.setText(data.get(3));
    	text_note.setText(data.get(4));
    }
    
    protected void clearInput() {
    	label_productNum.setText("");
    	text_productName.setText("");
    	text_price.setText("");
    	text_category.setText("");
    	text_note.setText("");
    }
	
	
	
	
	
	private boolean getUserInputParm() {
		boolean isRightData = false;
		productNum = text_productNum.getText();
		productName = text_productName.getText();
		price = text_price.getText();
		category = text_category.getSelectedText().toString();
		note = text_note.getText();
		productName = label_productName.getText();
		if (productNum.equals("") || productName.equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
	}

	protected int insertData() {
		int isInsert = 0;
		if (getUserInputParm() == true) {
			try {
				pstmt = con.prepareStatement(
						"INSERT INTO product(productNum,productName,price,category,note)VALUES(?,?,?,?,?)");
				pstmt.setString(1, productNum);
				pstmt.setString(2, productName);
				pstmt.setString(3, price);
				pstmt.setString(4, category);
				pstmt.setString(5, note);
				isInsert = pstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		return isInsert;
	}

	protected int updateData() {
		int isUpdate = 0;
		productName = label_productName.getText();
		if (getUserInputParm() == true && !productName.equals("")) {
			try {
				pstmt = con.prepareStatement(
						"UPDATE product SET productNum=?,productName=?,price=?,category=?,note=? WHERE productName = ?");
				pstmt.setString(1, productNum);
				pstmt.setString(2, productName);
				pstmt.setString(3, price);
				pstmt.setString(4, category);
				pstmt.setString(5, note);

				isUpdate = pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}

		}
		return isUpdate;
	}

	protected int delData() {
		int isDel = 0;
		productNum = label_productNum.getText();
		if (!productNum.equals("")) {
			try {
				pstmt = con.prepareStatement("DELETE FROM product WHERE productNum=?");
				pstmt.setString(1, productNum);
				isDel = pstmt.executeUpdate();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		return isDel;
	}

	protected LinkedList<String[]> queryData() {
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = con.prepareStatement("SELECT * FROM product");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[5];
				row[0]=rs.getString(productNum);
				row[1] = rs.getString("productName");
				row[2] = rs.getString("price");
				row[3] = rs.getString("category");
				row[4] = rs.getString("note");

				data.add(row);
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}

	protected LinkedList<String[]> search(String value) {
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = con.prepareStatement(
					"SELECT * FROM product WHERE productNum LIKE? OR productName LIKE ? OR price LIKE ? OR category LIKE ? OR note LIKE ?");
			String query = "%" + value + "%";
			for (int i = 1; i < 6; i++) {
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[5];
				
				row[0] = rs.getString("productNum");
				row[1] = rs.getString("productName");
				row[2] = rs.getString("price");
				row[3] = rs.getString("category");
				row[4] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}

	private void txtVendorNumKeyReleased(java.awt.event.KeyEvent evt) {
		String productNum = "";
		try {
			pstmt = con.prepareStatement("SELECT productNum FROM product Where productNum = ?");
			pstmt.setString(1, text_productNum.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				productNum = rs.getString("productNum");
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		if (productNum.equals("")) {
			JOptionPane.showMessageDialog(text_productNum, "查無此商品");
		}
	}

	// Variables declaration - do not modify
	private com.toedter.calendar.JDateChooser dateChooser;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel label_category;
	private javax.swing.JLabel label_dateTest;
	private javax.swing.JLabel label_note;
	private javax.swing.JLabel label_price;
	private javax.swing.JLabel label_productName;
	private javax.swing.JLabel label_productNum;
	private javax.swing.JTextField text_category;
	private javax.swing.JTextArea text_note;
	private javax.swing.JTextField text_price;
	private javax.swing.JTextField text_productName;
	private javax.swing.JTextField text_productNum;
	// End of variables declaration
}