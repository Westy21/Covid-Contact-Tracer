/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Entities.Record;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Westy
 */
public class RecordManager {
    /**
        Construct Record objects using data from Database and the opposite
    */
    
    private final static QueryManager QM = new QueryManager();
    
    public static String storeRecord(Record Record){
        return QM.store(Record);
    }
    
    public static ArrayList<Record> getStoredRecords(){
        ArrayList<Record>Records = new ArrayList();
        ResultSet ResultSet = QM.get();
        
        try {
            while(ResultSet.next()){
                Records.add(new Record(
                        ResultSet.getInt(1),
                        ResultSet.getString(2),
                        ResultSet.getString(3),
                        ResultSet.getString(4),
                        ResultSet.getInt(5),
                        ResultSet.getString(6),
                        ResultSet.getString(7),
                        ResultSet.getInt(8),
                        ResultSet.getInt(9),
                        ResultSet.getInt(10)
                ));
            }
            return Records;
        } catch (SQLException ex) {
            Logger.getLogger(RecordManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String deleteRecord(int RecordId){
        return QM.delete(RecordId);
    }
}
