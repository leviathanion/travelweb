package com.twentytwo.travelweb.serviceimpl;

import com.twentytwo.travelweb.entity.Product;
import com.twentytwo.travelweb.entity.ProductCom;
import com.twentytwo.travelweb.entity.ProductImg;
import com.twentytwo.travelweb.entity.ProductInfo;
import com.twentytwo.travelweb.mapper.ProductMapper;
import com.twentytwo.travelweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Integer addIntoOrder(String order_user, int order_product, int order_population, double order_price) {
        return productMapper.addIntoOrder(order_user,order_product,order_population,order_price);
    }

    @Override
    public List<Product> getProductClickByComId(String com_id) {
        return productMapper.getProductClickByComId(com_id);
    }
}
