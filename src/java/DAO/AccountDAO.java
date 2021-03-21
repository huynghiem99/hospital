/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connect.DBConnect;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AccountDAO {
    Connection conn = null;  // connect sql server
    PreparedStatement ps = null; // query from netbean to sql server
    ResultSet rs = null;
    
    public List<Account> getListAccount(){
        try {
            String query = "select * from account";
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Account> list = new ArrayList<>();
            while(rs.next()) {
                Account a = new Account(rs.getString(1),rs.getString(2));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            
        }
        
        return null;
    }
}
