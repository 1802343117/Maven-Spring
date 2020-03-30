package com.soft1851.spring.web.dao.Impl;

import com.soft1851.spring.web.dao.RankDao;
import com.soft1851.spring.web.entity.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RankDaoImpl implements RankDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Rank> selectAll() {
        String sql = "SELECT * FROM t_rank";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Rank.class));
    }

    @Override
    public int[] batchInsert(List<Rank> ranks) {
        final List<Rank> rankList = ranks;
        String sql = "INSERT INTO t_rank (name, url) " + "VALUES (?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Rank rank = rankList.get(i);
                preparedStatement.setString(1, rank.getHeroName());
                preparedStatement.setString(2, rank.getUrl());
            }

            @Override
            public int getBatchSize() {
                return rankList.size();
            }
        });
    }

    @Override
    public int insert(Rank rank) {
        String sql = "INSERT INTO t_rank (name, url) " + "VALUE (?, ?)";
        Object[] params = {
                rank.getHeroName(), rank.getUrl()
        };
        return jdbcTemplate.update(sql, params);
    }
}
