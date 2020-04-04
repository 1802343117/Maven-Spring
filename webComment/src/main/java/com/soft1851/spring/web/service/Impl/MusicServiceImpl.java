package com.soft1851.spring.web.service.Impl;

import com.soft1851.spring.web.dao.MusicDao;
import com.soft1851.spring.web.entity.Music;
import com.soft1851.spring.web.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 12559
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicDao musicDao;

    @Override
    public List<Music> queryAll() {
        return musicDao.selectAll();
    }

    @Override
    public int[] batchInsert(List<Music> musics) {
        return musicDao.batchInsert(musics);
    }

    @Override
    public void truncate() {
        musicDao.truncate();
    }
}
