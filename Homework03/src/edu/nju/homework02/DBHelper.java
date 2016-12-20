package edu.nju.homework02;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Tonndiyee on 2016/12/19.
 */
public class DBHelper {
    private static DBHelper instance = null;
    private DataSource datasource = null;
    private DBHelper(){
        InitialContext jndiContext = null;

        Properties properties = new Properties();
        properties.put(javax.naming.Context.PROVIDER_URL, "jnp:///");
        properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
        try {
            jndiContext = new InitialContext(properties);
            datasource = (DataSource) jndiContext.lookup("java:comp/env/jdbc/j2ee_student");
        }catch (NamingException e) {
            e.printStackTrace();
        }
    }
    public static DBHelper getInstance(){
        if(instance==null){
            return new DBHelper();
        }
        else{
            return instance;
        }
    }
    public Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }

}
