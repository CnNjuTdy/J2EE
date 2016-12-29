package model.dao.impl;

import model.dao.DaoHelper;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Tondiyee on 2016/12/28.
 */
public class DaoHelperImpl implements DaoHelper {
    private static DaoHelperImpl instance = null;
    private InitialContext jndiContext = null;
    private Connection connection = null;
    private DataSource datasource = null;
    private PreparedStatement stmt = null;

    private DaoHelperImpl() {
        Properties properties = new Properties();
        properties.put(javax.naming.Context.PROVIDER_URL, "jnp:///");
        properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.naming.java.javaURLContextFactory");

        try {
            jndiContext = new InitialContext(properties);
            datasource = (DataSource) jndiContext.lookup("java:comp/env/jdbc/j2ee_student");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static DaoHelperImpl getInstance() {
        if (instance == null) {
            return new DaoHelperImpl();
        } else {
            return instance;
        }
    }

    @Override
    public ResultSet find(String sql, List params) {
        ResultSet rs = null;
        try {
            connection = datasource.getConnection();
            stmt = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                stmt.setString((i + 1), (String) params.get(i));
            }
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rs;
    }

    @Override
    public ResultSet find(String sql) {
        return find(sql,new ArrayList());
    }

    @Override
    public boolean update(String sql, List params) {
        try {
            connection = datasource.getConnection();
            stmt = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                stmt.setString((i + 1), (String) params.get(i));
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (connection != null && stmt != null) {
                    connection.close();
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean update(String sql) {
        return update(sql,new ArrayList());
    }

    @Override
    public void closeResultSet(ResultSet resultSet) {
        if(resultSet!=null){
            try {
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closeStatement() {
        if(stmt!=null){
            try {
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closeConnection() {
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
