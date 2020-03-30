package com.soft1851.spring.web.dao.Impl;

import com.soft1851.spring.web.dao.LolDao;
import com.soft1851.spring.web.entity.LOL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LolDaoImpl implements LolDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LOL> selectAll() {
        String sql = "SELECT * FROM t_lol";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LOL.class));
    }

    @Override
    public int[] batchInsert(List<LOL> lols) {
        final List<LOL> lolList = lols;
        String sql = "INSERT INTO t_lol (name, url) " + "VALUES (?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                LOL lol = lolList.get(i);
                preparedStatement.setString(1, lol.getHeroName());
                preparedStatement.setString(2, lol.getUrl());
            }

            @Override
            public int getBatchSize() {
                return lolList.size();
            }
        });
    }

    @Override
    public int insert(LOL lol) {
        String sql = "INSERT INTO t_lol (name, url) " + "VALUE (?, ?)";
        Object[] params = {
                lol.getHeroName(), lol.getUrl()
        };
        return jdbcTemplate.update(sql, params);
    }
}
