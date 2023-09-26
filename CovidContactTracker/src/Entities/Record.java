/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
/**
 *
 * @author Westy
 */
public class Record {
    
    private int ID;
    //ID is asigned by database after retreival
    
    public String Name, Surname, Contact, Address, EmailAddress;
    public int Age = 0, Temp = 0, Q1 = 7, Q2 = 7;
    //Q1 and Q2 should be either 1 or 0 but anyother number can be used as default.
        
    //To Database
    public Record(String Name, String Surname, String Contact, int Age, String Address, String EmailAddress, int Temp, int Q1,int Q2){
        this.Name = Name;
        this.Surname = Surname;
        this.Contact = Contact;
        this.Age = Age;
        this.Address = Address;
        this.EmailAddress = EmailAddress;
        this.Temp = Temp;
        this.Q1 = Q1;
        this.Q2 = Q2;
    }
    
    //From Database
    public Record(int ID,String Name, String Surname, String Contact, int Age, String Address, String EmailAddress, int Temp, int Q1,int Q2){
        this.ID = ID;
        this.Name = Name;
        this.Surname = Surname;
        this.Contact = Contact;
        this.Age = Age;
        this.Address = Address;
        this.EmailAddress = EmailAddress;
        this.Temp = Temp;
        this.Q1 = Q1;
        this.Q2 = Q2;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public int getID(){
        return this.ID;
    }
    
    public Object[] toArray(){
        return new Object[]{ID,Surname,Name,Contact,Age,Address,EmailAddress,Temp,Q1,Q2};
    }
    
}
