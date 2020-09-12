package com.twentytwo.travelweb.service;

import com.twentytwo.travelweb.entity.News;
import com.twentytwo.travelweb.entity.NewsInfo;

import java.util.List;

public interface NewsService {
    List<NewsInfo> getAllNewsInfo();
    Integer releaseNews(News news);
    Integer deleteNews(Integer news_id);
    Integer updateNews(News news);
    News getNewsById(Integer news_id);
}
