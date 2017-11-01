/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class Homework4 {

    class UsernameAlreadyInDatabaseException extends Exception {
        UsernameAlreadyInDatabaseException(String details) {
            super(details);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Homework4 app = new Homework4();
       app.run();
    }
    
    String getHash(Long salt, String password) {
        String Strsalt = salt.toString() + password;
        
        SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
        byte[] digest = digestSHA3.digest(Strsalt.getBytes());
        return Hex.toHexString(digest);
    }
    
    void reset()
    {
       db.sql("drop table if exists users");
       db.sql("create table users (username string, password string)");
    }
    
    void insertUser(String username, String password) {
        try {
            ResultSet rs = db.sql("select * from users where username = (?)", username);
            if (rs != null && rs.next()) {
                throw new UsernameAlreadyInDatabaseException("Cannot insert duplicate username into database"); 
            }
            rs = db.sql("insert into users (username, password) values ((?), (?))", username, "");
            Long id = getId(username);
            String hashedpassword = getHash(id, password);
            db.sql("update users set password = (?) where username = (?)", hashedpassword, username);
            } catch (SQLException ex) {
            Logger.getLogger(Homework4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UsernameAlreadyInDatabaseException ex) {
            Logger.getLogger(Homework4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Long getId(String username) {
        try {
            ResultSet rs = db.sql("select rowid from users where username = (?)", username);
            if(rs != null && rs.next())
            {
                return rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Homework4.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    boolean compareCredentials(String username, String password) {
        try {
            ResultSet rs = db.sql("select * from users where username = (?)", username);
            if(rs != null && rs.next()) {
                Long id = getId(username);
                String storedpw = rs.getString("password");
                if (getHash(id, password).equals(storedpw))
                    return true;
                else
                    return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Homework4.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    SQLite db  = new SQLite("sample.db");
    
    void run() {
       reset();
       insertUser("Bob", "1234");
       Long bobid = getId("Bob");
       System.out.println("Bob id = " + bobid.toString());
       insertUser("Alice", "p@ssw0rd");
       Long aliceid = getId("Alice");
       System.out.println("Alice id = " + aliceid.toString());
       System.out.println("Provided credentials are " + (compareCredentials("Bob", "1234") ? "correct":"incorrect"));
       System.out.println("Provided credentials are " + (compareCredentials("Alice", "password") ? "correct" : "incorrect"));
    }
    
}
