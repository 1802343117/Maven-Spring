package com.soft1851.spring.web.service.Impl;

import com.soft1851.spring.web.dao.RankDao;
import com.soft1851.spring.web.entity.Rank;
import com.soft1851.spring.web.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 12559
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class RankServiceImpl implements RankService {
    @Autowired
    private RankDao rankDao;

    @Override
    public List<Rank> queryAll() {
        return rankDao.selectAll();
    }

    @Override
    public void addLol(Rank rank) {
        rankDao.insert(rank);
    }

    @Override
    public int[] batchInsert(List<Rank> ranks) {
        return rankDao.batchInsert(ranks);
    }
}
