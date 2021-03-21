package connect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Admin
 */
public class DBConnect {
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public Connection getConnection()throws Exception {
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber + "\\" + instance +";databaseName="+dbName;
        if(instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
     
     public void thucThiCauLenhSQL(String sql) throws Exception{
		Connection conn = null;  // connect sql server
         PreparedStatement ps = null; // query from netbean to sql server
         ResultSet rs = null;
		conn = new DBConnect().getConnection();
                ps = conn.prepareStatement(sql);
                ps.executeQuery();
                
	}
    
     public ResultSet chonDuLieuTuDTB(String sql) throws Exception{
         Connection conn = null;  // connect sql server
         PreparedStatement ps = null; // query from netbean to sql server
         ResultSet rs = null;
		conn = new DBConnect().getConnection();
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                return rs;
	}
//      public String getImagePath() throws Exception {
//        return "image/";
//    }
    /*Insert your other code right after this comment*/
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "127.0.0.1";
    private final String dbName = "HospitalDB";
    private final String portNumber = "1433";
    private final String instance="";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final String userID = "sa";
    private final String password = "123456";

    private Connection connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
