
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class login extends javax.swing.JFrame {
	private Connection conn;
	private String logId =null, logPW=null, editPW="no";
	private boolean idOk=false, pwOk=false, ifedit=false, repeatPW=false;

    public login() {
    	databaseConnect();
        initComponents();
        init();
    }
    
    private void init(){
        setResizable(false);
        setLocationRelativeTo(null);//置中
        
        //title
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/drink.png")));
        setTitle("---ERP LOGIN---");
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        login = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loginLabel02 = new javax.swing.JLabel();
        loginLabel01 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        employID_login = new javax.swing.JTextField();
        employPW_login = new javax.swing.JPasswordField();
        loginLabel03 = new javax.swing.JLabel();
        employPwEdit_login = new javax.swing.JPasswordField();
        login_log = new javax.swing.JButton();
        showResult_login = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 500));

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        loginLabel02.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        loginLabel02.setText("密碼");

        loginLabel01.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        loginLabel01.setText("員工編號");

        employID_login.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N

        employPW_login.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N

        loginLabel03.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        loginLabel03.setText("修改密碼");

        employPwEdit_login.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        employPwEdit_login.setText("");

        login_log.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        login_log.setText("登入");
        login_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_logActionPerformed(evt);
            }
        });

        showResult_login.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        showResult_login.setForeground(new java.awt.Color(255, 51, 51));
        showResult_login.setText("");

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(loginLayout.createSequentialGroup()
                                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginLabel01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(loginLabel02, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(employID_login, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                    .addComponent(employPW_login))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addGroup(loginLayout.createSequentialGroup()
                                .addComponent(loginLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(loginLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(login_log, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(showResult_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addComponent(employPwEdit_login, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 56, Short.MAX_VALUE))))))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employID_login)
                    .addComponent(loginLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginLabel02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employPW_login, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginLabel03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employPwEdit_login, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(login_log, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(showResult_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>      
    
    //抓到輸入欄位資料
    private void getInput(){
    	logId = employID_login.getText();
    	logPW = new String(employPW_login.getPassword());
    	editPW = new String(employPwEdit_login.getPassword());
    }    
   
    
    private void checkId(){ //點送出後check資料
    	if(editPW.length()>0){
    		ifedit =true;
    	}    	    	
    	
    	try{
    		PreparedStatement p1 = conn.prepareStatement("select * from employee where employeeNum="+logId);
    		ResultSet rs = p1.executeQuery();
    		while(rs.next()){    			
    			pwOk =true;
    			break;
    		}
    		
    		PreparedStatement p2 = conn.prepareStatement("select * from admin where employeeNum="+logId);
    		ResultSet rs2 = p2.executeQuery();
    		while(rs2.next()){
    			String sqlPW = rs2.getString("password");
    			if(sqlPW.equals(logPW)){
    				idOk =true;
    			}
    			
    			if(sqlPW.equals(editPW)){
    				repeatPW =true;
    			}
    			break;
    		}
    		
    		if(idOk & pwOk & !ifedit){
    			erp_frame erp_main = new erp_frame(logId);//跳到main頁面    	
    			erp_main.setVisible(true);	      
    	        dispose(); //關掉原本的視窗
    		}else if(idOk & pwOk & ifedit & !repeatPW){ //帳密正確且要修改密碼
    			changePW();//修改密碼
    			getDefault();//所有條件初始化
    			showResult_login.setText("密碼修改成功，請重新登入");
    		
    		}else{    			
    			getDefault();//所有條件初始化
    			showResult_login.setText("帳號/密碼設定錯誤");
    		}
    	}catch(Exception a){
    		System.out.println("checkId error");
    		a.printStackTrace();
    	}
    }   
    
    //TODO 改密碼機制，只打空白不接受，就密碼同新密碼不接受
    
    private void getDefault(){ //所有條件初始化
    	employPwEdit_login.setText("");
		employPW_login.setText("");
		employID_login.setText("");		
		idOk=false; 
		pwOk=false; 
		ifedit=false; 
		repeatPW=false; logId =null; logPW=null; editPW="no";
    }
    
    private void changePW(){ //修改密碼
//    	update admin set password= newid where employeeNum=userid;    	
    	try {
    		PreparedStatement p1 = conn.prepareStatement("update admin set password="+editPW+" where employeeNum="+logId);
    		p1.executeUpdate();
    		ifedit = false;
    	} catch (Exception e) {
			System.out.println("changePW error: "+ e.toString());
			e.printStackTrace();
		}
    }
    
    private void login_logActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	getInput();
    	checkId();
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
    

    public static void main(String args[]) {
          try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField employID_login;
    private javax.swing.JPasswordField employPW_login;
    private javax.swing.JPasswordField employPwEdit_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel login;
    private javax.swing.JLabel loginLabel01;
    private javax.swing.JLabel loginLabel02;
    private javax.swing.JLabel loginLabel03;
    private javax.swing.JButton login_log;
    private javax.swing.JLabel showResult_login;
    // End of variables declaration                   
}
