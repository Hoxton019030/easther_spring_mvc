package com.web.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.dao.ProductDao;
import com.web.store.model.BookBean;
import com.web.store.model.CompanyBean;
import com.web.store.service.ProductService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

	ProductDao productdao;

	@Autowired
	public ProductServiceImpl(ProductDao productdao) {
		this.productdao = productdao;
	}

	@Override
	public List<BookBean> getAllProducts() {
		return productdao.getAllProducts();
	}

	@Override
	public void updateAllStocks() {
		List<BookBean> allProducts = productdao.getAllProducts();
		for (BookBean bb : allProducts) {
			if (bb.getStock() != null && bb.getStock() < 50) {
				productdao.updateStock(bb.getBookId(), bb.getStock() + 50);
			}
		}

	}

	@Override
	public List<String> getAllCategories() {
		return productdao.getAllCategories();
	}

	@Override
	public List<BookBean> getProductsByCategory(String category) {
		return productdao.getProductsByCategory(category);
	}

	@Override
	public BookBean getProductById(int productId) {
		return productdao.getProductById(productId);
	}

	@Override
	public void addProduct(BookBean product) {
		productdao.addProduct(product);

	}

	@Override
	public CompanyBean getCompanyById(int companyId) {
		return productdao.getCompanyById(companyId);
	}

	@Override
	public List<CompanyBean> getCompanyList() {
		return productdao.getCompanyList();
	}

}
