package ch06_sll.ex01.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch06_sll.ex01.dao.CategoryDao;
import ch06_sll.ex01.dao.impl.CategoryDaoImpl;
import ch06_sll.ex01.model.Category;
import ch06_sll.ex01.service.CategoryService;
import ch06_sll.init.HibernateUtils;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao  categoryDao;
	SessionFactory  factory;
	
	public CategoryServiceImpl() {
		this.categoryDao = new CategoryDaoImpl();
		this.factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Category findById(int id) {
		Category category = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			category = categoryDao.findById(id);
			tx.commit();
		} catch(Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		return category;
	}

	@Override
	public Category findByName(String categoryName) {
		Category category = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    category = categoryDao.findByName(categoryName);
		    tx.commit();
		} catch(Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		return category;
	}

	@Override
	public void closeFactory() {
		categoryDao.closeFactory();
	}

	@Override
	public Object save(Category category) {
		Object obj = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			obj = categoryDao.save(category);
			tx.commit();
		} catch(Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		return obj;
	}

	@Override
	public List<Category> findAll() {
		List<Category>  categories = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("1.******************");
		    categories = categoryDao.findAll();
		    System.out.println("2.******************");
		    tx.commit();
		} catch(Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		return categories;
	}
}
