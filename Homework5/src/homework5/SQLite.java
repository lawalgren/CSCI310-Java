/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework5;

/**
 *
 * @author Lucas
 */
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
 * @author Lucas
 */
public class SQLite {

    private Connection connection = null;
    public static final int SQL_TIMEOUT_SECONDS = 10;

    public SQLite(String db) {
        try {
           connection = DriverManager.getConnection("jdbc:sqlite:" + db);
        } catch (SQLException ex) {
            Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet sql(String sql, Object... objects) {
        try {
            int keyMode = sql.startsWith("insert") ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, keyMode);
            preparedStatement.setQueryTimeout(SQL_TIMEOUT_SECONDS);
            int index = 1;
            for (Object object:objects) {
                if (object instanceof Boolean)
                    preparedStatement.setBoolean(index, (Boolean) object);
                else if (object instanceof String)
                    preparedStatement.setString(index, (String) object);
                else if (object instanceof Integer)
                    preparedStatement.setInt(index, (Integer) object);
                else if (object instanceof Long)
                    preparedStatement.setLong(index, (Long) object);
                else
                    throw new IllegalStateException("can't set type " + object.getClass().getName());  
                ++index;
            }
            if(sql.startsWith("insert") || sql.startsWith("delete") || sql.startsWith("update")) {
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                return resultSet;
            }
            else if(sql.startsWith("select")) {
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet;
            }
            else {
                preparedStatement.execute();
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
