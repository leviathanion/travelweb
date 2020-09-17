package com.twentytwo.travelweb.serviceimpl;

import com.twentytwo.travelweb.entity.*;
import com.twentytwo.travelweb.mapper.ProductMapper;
import com.twentytwo.travelweb.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("routeService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> getAllProducts() {
        return productMapper.getAllProducts();
    }

    @Override
    public List<ProductInfo> getAllProductInfo() {
        return productMapper.getAllProductInfo();
    }

    @Override
    public Integer deleteProduct(Integer product_id) {
        return productMapper.deleteProduct(product_id);
    }

    @Override
    public Integer updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public Product getProductById(Integer product_id) {
        return productMapper.getProductById(product_id);
    }

    @Override
    public List<Product> getProductClickSum() {
        return productMapper.getProductClickSum();
    }

    @Override
    public List<ProductCom> getComClickSum() {
        return productMapper.getComClickSum();
    }

    @Override
    public List<ProductInfo> getProductInfoByComId(String com_id) {
        return productMapper.getProductInfoByComId(com_id);
    }

    @Override
    public Integer addPorduct(Product product) {
        return productMapper.addPorduct(product);
    }

    @Override
    public ProductInfo findOneProductInfo(Integer product_id) {
        ProductInfo productInfo =productMapper.findOneProductInfoById(product_id);
        List<ProductImg> productImg = productMapper.findProductImg(product_id);
        productInfo.setProductImgList(productImg);
        return productInfo;

    }

    @Override
    public Integer addIntoOrder(Order order) {
        return productMapper.addIntoOrder(order);
    }


    @Override
    public PageBean<Product> pageQuery(int category_id, int currentPage, int pageSize,String category_name) {
        if (("null".equals(category_name)|| StringUtils.isBlank(category_name))&&category_id!=0){
            int totalCount = productMapper.findTotalCount(category_id);
            //封装PageBean
            PageBean<Product> pageBean=new PageBean<>();
            //设置当前页码
            pageBean.setCurrentPage(currentPage);
            //设置每页显示条数
            pageBean.setPageSize(pageSize);
            //设置总记录数
//        int totalCount = routeDao.findTotalCount(category_id);
            pageBean.setTotalCount(totalCount);
            //设置当页显示的数据集合
            int start=pageSize*(currentPage-1);//每页的首条记录索引

            List<Product> byPage= productMapper.findByPage(category_id, start, pageSize);

            pageBean.setList(byPage);
            //设置总页数
            int totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
            pageBean.setTotalPage(totalPage);

            return pageBean;
        }else {
            int totalCount;
            if (category_id != 0){
                totalCount=productMapper.findTotalCount4(category_id,"%"+category_name+"%");
            }else if (category_name!=null&&category_name.length()>0){
                totalCount=productMapper.findTotalCount3("%"+category_name+"%");
            }else {
                totalCount=productMapper.findTotalCount1();
            }

            //封装PageBean
            PageBean<Product> pageBean=new PageBean<>();
            //设置当前页码
            pageBean.setCurrentPage(currentPage);
            //设置每页显示条数
            pageBean.setPageSize(pageSize);
            //设置总记录数
//        int totalCount = routeDao.findTotalCount(category_id);
            pageBean.setTotalCount(totalCount);
            //设置当页显示的数据集合
            int start=pageSize*(currentPage-1);//每页的首条记录索引

            List<Product> byPage;
            if (category_id != 0){
                byPage = productMapper.findByPage4(category_id, start, pageSize,"%"+category_name+"%");
            }else if (category_name!=null&&category_name.length()>0){
                byPage = productMapper.findByPage3(start, pageSize,"%"+category_name+"%");
            }else {
                byPage = productMapper.findByPage1(start, pageSize);
            }

            pageBean.setList(byPage);

            //设置总页数
            int totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
            pageBean.setTotalPage(totalPage);
            return pageBean;
        }
    }

    @Override
    public Product findOneRoute(int product_id) {

        Product oneRoute = productMapper.findOneRoute(product_id);
//        int favoriteCount = routeMapper.findFavoriteCountByRid(product_id);
        List<ProductImg> routeImg = productMapper.findRouteImg(product_id);
        Company seller = productMapper.findSeller(oneRoute.getCom_id());

//        oneRoute.setCount(favoriteCount);
        oneRoute.setCompany(seller);
        oneRoute.setRouteImgList(routeImg);


        return oneRoute;
    }
    @Override
    public List<Product> clickFourRank() {
        return productMapper.findClickFourRank();
    }

    @Override
    public Integer checkProduct(Integer product_id) {
        return productMapper.checkProduct(product_id);
    }

    @Override
    public List<Product> theNewFour() {
        return productMapper.findNewFour();
    }

    @Override
    public int findTotalRoute() {
        return productMapper.findTotalCount1();
    }

    @Override
    public List<Product> findRandFourRoute(int one,int two,int three,int four) {
        return productMapper.findRandFourRoute(one,two,three,four);
    }

    @Override
    public List<NewsInfo> newsList() {
        return productMapper.findNews();
    }

    @Override
    public List<Product> getProductClickByComId(String com_id) {
        return productMapper.getProductClickByComId(com_id);

    }
}
