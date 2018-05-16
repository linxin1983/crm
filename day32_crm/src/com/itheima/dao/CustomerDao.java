package com.itheima.dao;

import java.util.List;

import org.hibernate.Session;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;

public class CustomerDao {
	
	/**
	 * 保存客户
	 * @param customer
	 */
	public void save(Customer customer){
		Session session = HibernateUtils.getCurrentSession();
		session.save(customer);
	}

	/**
	 * 查询所有的客户
	 * @return
	 */
	public List<Customer> findAll() {
		Session session = HibernateUtils.getCurrentSession();
		return session.createQuery("from Customer").list();
	}

}
