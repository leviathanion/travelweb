package com.twentytwo.travelweb.serviceimpl;


import com.twentytwo.travelweb.entity.Category;
import com.twentytwo.travelweb.mapper.CategoryMapper;
import com.twentytwo.travelweb.service.CategoryService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {



    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public Map<String,String> findAll() {

        HashMap hm = new HashMap();
        Map<String,String> categorys=hm;


        //2、判断是否存在数据
        if (MapUtils.isEmpty(categorys)){
            //3、如果为空从数据库进行查询
            //3.1 从数据库查询
            List<Category> list=categoryMapper.findAll();
            //3.2 将数据存储到redis
            for (int i=0;i<list.size();i++){
                hm.put(String.valueOf(list.get(i).getCategory_id()),list.get(i).getCategory_name());
            }
            categorys=hm;
        }
        return categorys;
    }
}
