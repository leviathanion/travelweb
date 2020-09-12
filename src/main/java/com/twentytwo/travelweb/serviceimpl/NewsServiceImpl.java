package com.twentytwo.travelweb.serviceimpl;

import com.twentytwo.travelweb.entity.News;
import com.twentytwo.travelweb.entity.NewsInfo;
import com.twentytwo.travelweb.mapper.NewsMapper;
import com.twentytwo.travelweb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public List<NewsInfo> getAllNewsInfo() {
        return newsMapper.getAllNewsInfo();
    }

    @Override
    public Integer releaseNews(News news) {
        return newsMapper.releaseNews(news);
    }

    @Override
    public Integer deleteNews(Integer news_id) {
        return newsMapper.deleteNews(news_id);
    }

    @Override
    public Integer updateNews(News news) {
        return newsMapper.updateNews(news);
    }

    @Override
    public News getNewsById(Integer news_id) {
        return newsMapper.getNewsById(news_id);
    }
}
