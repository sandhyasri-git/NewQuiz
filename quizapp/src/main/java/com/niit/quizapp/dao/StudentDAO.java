package com.niit.quizapp.dao;

import com.niit.quizapp.model.Student;

public interface StudentDAO {

	public boolean saveOrUpdate(Student student);
	public boolean isValidUser(String name, boolean isAdmin);
	public Student get(String uname);

}
