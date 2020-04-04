package com.soft1851.spring.web.dao.Impl;

import com.soft1851.spring.web.dao.MusicDao;
import com.soft1851.spring.web.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 12559
 */

@Repository
public class MusicDaoImpl implements MusicDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Music> selectAll() {
        String sql = "SELECT * FROM t_music";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Music.class));
    }

    @Override
    public int[] batchInsert(List<Music> musics) {
        final List<Music> musicList1 = musics;
        String sql = "INSERT INTO t_music (title, url, singer, cover) " + "VALUES (?, ?, ?, ?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Music music = musicList1.get(i);
                preparedStatement.setString(1, music.getTitle());
                preparedStatement.setString(2, music.getUrl());
                preparedStatement.setString(3, music.getSinger());
                preparedStatement.setString(4, music.getCover());
            }

            @Override
            public int getBatchSize() {
                return musicList1.size();
            }
        });
    }

    @Override
    public void truncate() {
        String sql = "TRUNCATE TABLE t_music";
        jdbcTemplate.update(sql);
    }
}
