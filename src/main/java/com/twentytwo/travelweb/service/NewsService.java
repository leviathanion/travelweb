package com.twentytwo.travelweb.service;

import com.twentytwo.travelweb.entity.News;
import com.twentytwo.travelweb.entity.NewsInfo;
import com.twentytwo.travelweb.entity.PageBean;
import com.twentytwo.travelweb.entity.Product;

import java.util.List;

public interface NewsService {
    List<NewsInfo> getAllNewsInfo();
    Integer releaseNews(News news);
    Integer deleteNews(Integer news_id);
    Integer updateNews(News news);
    News getNewsById(Integer news_id);
    List<NewsInfo> getNewsInfoByComId(String com_id);
    NewsInfo getNewsInfoByID(int news_id);
    Integer checkNews(Integer news_id);
    PageBean<News> pageQuery(int category_id, int currentPage, int pageSize, String name);
}
