package com.hotelworld.dao;

import java.util.List;

/**
 * Created by Tondiyee on 2017/3/7.
 */
public interface BaseDao {
    //搜索方法
    public<T> List<T> findBySQL(final String sql,final Object[] params,final Class<T> entityType);
    //更新方法
    public int updateBySQL(final String sql, final Object[] params);

}
