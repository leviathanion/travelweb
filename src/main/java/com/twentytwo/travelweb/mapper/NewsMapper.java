package com.twentytwo.travelweb.mapper;

import com.twentytwo.travelweb.entity.News;
import com.twentytwo.travelweb.entity.NewsInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsMapper {

    @Select("select * from news_info")
    List<News> getAllNews();

    @Select("select news_info.*,product_info.product_name,com_info.com_name from news_info,product_info,com_info where news_info.news_product=product_info.product_id and product_info.product_com=com_info.com_id")
    List<NewsInfo> getAllNewsInfo();

    @Insert("insert into news_info (news_title,news_content,news_img_url,news_product,news_create_date) values (#{news_title},#{news_content},#{news_img_url},#{news_product},sysdate())")
    Integer releaseNews(News news);

    @Delete("delete from news_info where news_id=#{news_id}")
    Integer deleteNews(Integer news_id);

    @Update("update news_info set news_title=#{news_title},news_content=#{news_content},news_img_url=#{news_img_url},news_product=#{news_product} where news_id=#{news_id}")
    Integer updateNews(News news);

    @Select("select * from news_info where news_id=#{news_id}")
    News getNewsById(Integer news_id);
}
