import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

public class Department extends javax.swing.JPanel {
	private Connection conn;
	private String depId=null, depName=null;

    public Department() {
    	databaseConnect();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        assetLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        id_department = new javax.swing.JLabel();
        depName_department = new javax.swing.JTextField();

        setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        setMinimumSize(new java.awt.Dimension(980, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assetLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        assetLabel2.setText("部門ID");
        add(assetLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, 30));

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        jLabel1.setText("部門名稱");
        jLabel1.setMaximumSize(new java.awt.Dimension(75, 25));
        jLabel1.setMinimumSize(new java.awt.Dimension(75, 25));
        jLabel1.setPreferredSize(new java.awt.Dimension(75, 25));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 191, -1, -1));

        id_department.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        add(id_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 269, 30));

        depName_department.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        add(depName_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 188, 269, -1));
    
     }// </editor-fold>  
  
    protected void getDefault(){
    	depId=null; depName=null;
    	depName_department.setText("");
    	id_department.setText("");
    }
    
  //取得輸入資料
    protected boolean getSelect(){
    	boolean isRightData = false;
    	//get remark content
    	depName = depName_department.getText(); 
    	if (depName.equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
    }
    
    protected int insertDB(){
    	int isInsert = 0;
    	if (getSelect() == true) {
	    	String sql = "insert into department(department) values(?)";
	    	    
	    	try{	    			    		
		    	PreparedStatement insertdb = conn.prepareStatement(sql); 
		    	insertdb.setString(1, depName);
		    	isInsert = insertdb.executeUpdate();
	    	}catch(Exception a){
	    		System.out.println("insertDB error");
	    		a.printStackTrace();
	    	}
    	}
    	return isInsert;
    }
    
	protected int delData(){
		int isDel = 0;
		if(!id_department.getText().equals("")){
			try{
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM department WHERE id = ?");
				pstmt.setString(1, id_department.getText());
				isDel = pstmt.executeUpdate();
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
		}
		
		return isDel;
	}
    
    protected int editDB(){	
    	depId = id_department.getText();
		int isUpdate = 0;
		if (getSelect() == true) {
	    	String sql = "update department set department=? where id="+depId;
	  	 	try{	    			    		
		    	PreparedStatement editdb = conn.prepareStatement(sql); 
		    	editdb.setString(1, depName);
		    	isUpdate = editdb.executeUpdate();
	      	}catch(Exception a){
		    		System.out.println("editDB error");
		    		a.printStackTrace();
		    }   
		}
		return isUpdate;	
    }
    
    protected  LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM department WHERE id LIKE ? OR department LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<3; i++){
				pstmt.setString(i, query);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String [2];	
	    		row [0] = rs.getString("id");
	    		row [1] = rs.getString("department"); 	    		
	    		data.add(row);
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return data;
	}
    
    protected LinkedList<String[]> queryData() {
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM department");
			ResultSet rs = pstmt.executeQuery();
	    	while(rs.next()){
	    		String[] row = new String [2];	
	    		row [0] = rs.getString("id");
	    		row [1] = rs.getString("department"); 	    		
	    		data.add(row);
			}
		}
		catch(SQLException ee){			
			System.out.println("p_query"+ee.toString());
		}
		return data;
    }
    
    protected void setInputValue(HashMap<Integer, String> data) {
    	id_department.setText(data.get(0));    	
    	depName_department.setText(data.get(1));    			
	}
    
    private void databaseConnect(){
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost/erp";
//			String url ="jdbc:mysql://112.104.57.22/iii2003";
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "");
//			prop.setProperty("createDatabaseIfNotExist", "true");			
			prop.setProperty("useSSL", "false");
			prop.setProperty("useUnicode", "true");
			prop.setProperty("characterEncoding", "UTF-8");		
			
			conn = DriverManager.getConnection(url, prop);
        
        } catch (Exception e) {
			System.out.println("sql conn error: "+ e.toString());
			e.printStackTrace();
		}
    }
    
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel assetLabel2;
    private javax.swing.JTextField depName_department;
    private javax.swing.JLabel id_department;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
