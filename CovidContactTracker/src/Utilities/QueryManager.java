/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Entities.Record;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Westy
 */
public class QueryManager {
    /*
        Manage Database conenction, Statement execution and Pool data from database
    */
    private static Connection Connection;
    private static Statement Statement;
    private ResultSet ResultSet;
    private static final String Table = "tracking_register_db.event_participants";
    private static final String URL="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull"
        ,User="root",Pass="westy";
    
    //connect to the database
    public static boolean connect(){
        try {
            Connection = DriverManager.getConnection(URL, User, Pass);
            Statement = Connection.createStatement();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    //store a record to the database
    public String store(Record Record){
        try {
            String Query = "INSERT INTO "+Table+" VALUES( null,'"+Record.Surname+"','"+Record.Name+"','"+Record.Contact+"',"+Record.Age+","
                    + "'"+Record.Address+"','"+Record.EmailAddress+"',"+Record.Temp+","+Record.Q1+","+Record.Q2+");";
            Statement.execute(Query);
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            return "Upload failed";
        }
        return "Upload Successful.";
    }

    //retrieve records from the database
    public ResultSet get(){
        try {
            String Query = "SELECT * FROM "+Table;
            Statement.execute(Query);
            ResultSet = Statement.getResultSet();
            if(ResultSet!=null){
                return ResultSet;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String delete(int id){
        try {
            //delete by id
            String Query = "DELETE FROM " + Table + " WHERE id="+id+";";
            Statement.execute(Query);
            return "Deletion sucessfuly";
        } catch (SQLException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            return "Deletion Unsuccessful";
        }
    }
    
    //disconnect from the database
    public void disconnect(){
        if(Connection !=null){
            try {
                Connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
