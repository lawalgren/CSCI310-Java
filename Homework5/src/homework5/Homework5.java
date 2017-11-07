/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class Homework5 {

    class UsernameAlreadyInDatabaseException extends Exception {

        UsernameAlreadyInDatabaseException(String details) {
            super(details);
        }
    }

    class User {

        public String Username;
        public String Password;

        User(String _Username, String _Password) {
            Username = _Username;
            Password = _Password;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Homework5 app = new Homework5();
        app.run();
    }

    String getHash(Long salt, String password) {
        String Strsalt = salt.toString() + password;

        SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
        byte[] digest = digestSHA3.digest(Strsalt.getBytes());
        return Hex.toHexString(digest);
    }

    void reset() {
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
            Logger.getLogger(Homework5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UsernameAlreadyInDatabaseException ex) {
            Logger.getLogger(Homework5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Long getId(String username) {
        try {
            ResultSet rs = db.sql("select rowid from users where username = (?)", username);
            if (rs != null && rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Homework5.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    boolean compareCredentials(String username, String password) {
        try {
            ResultSet rs = db.sql("select * from users where username = (?)", username);
            if (rs != null && rs.next()) {
                Long id = getId(username);
                String storedpw = rs.getString("password");
                if (getHash(id, password).equals(storedpw)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Homework5.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    SQLite db = new SQLite();

    void run() {
        ArrayList<User> Users = makeUsers(10);
        ArrayList<User> AltUsers = makeAltUsers(10);
        reset();
        System.out.println("Series: \n");

        Users.stream().forEach(User -> {
            insertUser(User.Username, User.Password);
            System.out.println("Id = " + getId(User.Username));
            System.out.println("Provided credentials are " + (compareCredentials(User.Username, User.Password) ? "correct" : "incorrect") + " for " + User.Username);
            System.out.println("Provided credentials are " + (compareCredentials(User.Username, "1234") ? "correct" : "incorrect") + " for " + User.Username);
        });
        
        System.out.println("\nParallel: \n");

        AltUsers.parallelStream().forEach(User -> {
            synchronized(this) {
                insertUser(User.Username, User.Password);
            }
            System.out.println("Id = " + getId(User.Username));
            System.out.println("Provided credentials are " + (compareCredentials(User.Username, User.Password) ? "correct" : "incorrect") + " for " + User.Username);
            System.out.println("Provided credentials are " + (compareCredentials(User.Username, "1234") ? "correct" : "incorrect") + " for " + User.Username);
        });
    }

    ArrayList<User> makeUsers(int n) {

        ArrayList Users = new ArrayList<User>();

        for (int i = 0; i < n; i++) {
            Users.add(new User(("B" + i + "b"), ("P@ssw" + i + "rd")));
        }

        return Users;
    }
    
    ArrayList<User> makeAltUsers(int n) {

        ArrayList Users = new ArrayList<User>();

        for (int i = 0; i < n; i++) {
            Users.add(new User(("P" + i + "rrry"), ("P@ssw" + i + "rd")));
        }

        return Users;
    }
}
