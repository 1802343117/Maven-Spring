package com.soft1851.spring.web.service.Impl;

import com.soft1851.spring.web.dao.LolDao;
import com.soft1851.spring.web.entity.LOL;
import com.soft1851.spring.web.service.LolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class LolServiceImpl implements LolService {
    @Autowired
    private LolDao lolDao;

    @Override
    public List<LOL> queryAll() {
        return lolDao.selectAll();
    }

    @Override
    public void addLol(LOL lol) {
        lolDao.insert(lol);
    }

    @Override
    public int[] batchInsert(List<LOL> lols) {
        return lolDao.batchInsert(lols);
    }
}
