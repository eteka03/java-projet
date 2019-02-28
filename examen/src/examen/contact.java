/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eteka
 */
public class contact {
    
    public String adress;
    public String prenom;
    public String nom;
    public String email;
    public String numero;
    
    public contact(){
    
    adress  = "undefini";
    prenom = "undefini";
    nom = "undefini";
    email = "undefini";
    numero = "undefini";
    }
    
    public contact(String adresse,String prenam,String name ,String emal, String num){
    
    adress = adresse;
    prenom = prenam;
    nom = name;
    email  = emal;
    numero = num;
    
    }
    
    public void inserer(){
    
    String url = "jdbc:mysql://localhost:3306/examenjava?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    
      String user = "root";
            String pw = "";
            
            
            Connection con;
        try {
            con = DriverManager.getConnection(url,user,pw);
            
         
            
          String req = "insert into contacte(adress_id,prenom,nom,email,numero) values (?,?,?,?,?);";
           
            
            PreparedStatement prepar = con.prepareStatement(req);
            prepar.setString(1, adress);
            
            prepar.setString(2,prenom);
            
            prepar.setString(3,nom);
            
            prepar.setString(4,email);
            
            prepar.setString(5,numero);
            
            prepar.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(contact.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    }
    
    
   
    
}
