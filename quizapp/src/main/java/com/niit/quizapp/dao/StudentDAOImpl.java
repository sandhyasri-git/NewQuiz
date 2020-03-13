package com.niit.quizapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.quizapp.model.Student;

@Repository(value="studentDAO")
@EnableTransactionManagement

public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public StudentDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	public StudentDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Transactional
	public boolean saveOrUpdate(Student student) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(student);
			return  true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}	
	}
	@Transactional
	public boolean isValidUser(String password, boolean isAdmin) {
		String hql = "from Student where password ='" + password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		
		return false;
	}
	@Transactional
	public Student get(String uname) {
		try{
			
			return sessionFactory.getCurrentSession().createQuery("from Student where studentname=:uname", Student.class).setParameter("uname", uname).getSingleResult();
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in get method of userDAO");
			e.printStackTrace();
			return null;
		}
	}



}
