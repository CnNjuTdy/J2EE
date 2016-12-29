package model.dao;

import java.sql.ResultSet;
import java.util.List;

public interface DaoHelper {
    public ResultSet find(String sql, List params);

    public ResultSet find(String sql);

    public boolean update(String sql, List params);

    public boolean update(String sql);

    public void closeResultSet(ResultSet resultSet);
    public void closeStatement();
    public void closeConnection();
}
