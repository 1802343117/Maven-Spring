package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.entity.Music;
import com.soft1851.spring.web.spider.MusicSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class MusicServiceTest {

    @Autowired
    private MusicService musicService;

    @Test
    public void batchInsert() {
        for (Music music: MusicSpider.musicSpider()) {
            if(music.getTitle() != null && music.getUrl() != null && music.getSinger() != null && music.getCover() != null) {
                int []ints = musicService.batchInsert(MusicSpider.musicSpider());
                assertEquals(MusicSpider.musicSpider().size(), ints.length);
                System.out.println("数据已全部插入");
            }
        }
    }
}