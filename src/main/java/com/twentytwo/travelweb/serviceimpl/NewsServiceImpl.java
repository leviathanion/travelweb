package com.twentytwo.travelweb.serviceimpl;

import com.twentytwo.travelweb.entity.News;
import com.twentytwo.travelweb.entity.NewsInfo;
import com.twentytwo.travelweb.entity.PageBean;
import com.twentytwo.travelweb.entity.Product;
import com.twentytwo.travelweb.mapper.NewsMapper;
import com.twentytwo.travelweb.service.NewsService;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public List<NewsInfo> getNewsInfoByComId(String com_id) {
        return newsMapper.getNewsInfoByComId(com_id);
    }

    @Override
    public NewsInfo getNewsInfoByID(int news_id) {
        return newsMapper.getNewsInfoByID(news_id);
    }

    @Override
    public Integer checkNews(Integer news_id) {
        return newsMapper.checkNews(news_id);
    }

    @Override
    public PageBean<News> pageQuery(int category_id, int currentPage, int pageSize, String category_name) {
        if ("null".equals(category_name)|| StringUtils.isBlank(category_name)||category_name==null){
            int totalCount = newsMapper.findTotalCount();
            //封装PageBean
            PageBean<News> pageBean=new PageBean<>();
            //设置当前页码
            pageBean.setCurrentPage(currentPage);
            //设置每页显示条数
            pageBean.setPageSize(pageSize);
            //设置总记录数
//        int totalCount = routeDao.findTotalCount(category_id);
            pageBean.setTotalCount(totalCount);
            //设置当页显示的数据集合
            int start=pageSize*(currentPage-1);//每页的首条记录索引

            List<News> byPage = newsMapper.findByPage(start, pageSize);

            pageBean.setList(byPage);
            //设置总页数
            int totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
            pageBean.setTotalPage(totalPage);

            return pageBean;
        }else {
            int totalCount;

            totalCount = newsMapper.findTotalCount1("%"+category_name+"%");

            //封装PageBean
            PageBean<News> pageBean=new PageBean<>();
            //设置当前页码
            pageBean.setCurrentPage(currentPage);
            //设置每页显示条数
            pageBean.setPageSize(pageSize);
            //设置总记录数
//        int totalCount = routeDao.findTotalCount(category_id);
            pageBean.setTotalCount(totalCount);
            //设置当页显示的数据集合
            int start=pageSize*(currentPage-1);//每页的首条记录索引

            List<News> byPage;

            byPage = newsMapper.findByPage1(start,pageSize,"%"+category_name+"%");

            pageBean.setList(byPage);

            //设置总页数
            int totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
            pageBean.setTotalPage(totalPage);
            return pageBean;
        }
    }
}
