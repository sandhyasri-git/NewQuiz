package com.niit.quizapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.quizapp.model.QuestionOptions;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


@Repository("questionOptionsDAO")
@EnableTransactionManagement
public class QuestionOptionsDAOImpl implements QuestionOptionsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<QuestionOptions> listQuestionOptions() {
		return sessionFactory.getCurrentSession().createQuery(
				"from QuestionOptions where quesOpId=1").list();
	}

	
	public QuestionOptionsDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public QuestionOptionsDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<QuestionOptions> getQuestionOptionsByQuestionId(Long questionId) {
		return sessionFactory.getCurrentSession().createQuery(
				"from QuestionOptions where questionId=:questionId")
				.setParameter("questionId", questionId).list();
	}

	@Transactional
	public void saveQuestionOptions(QuestionOptions questionOptions) {
		sessionFactory.getCurrentSession().saveOrUpdate(questionOptions);
	}

	@Transactional
	public void updateQuestionOptions(QuestionOptions questionOptions) {
		sessionFactory
				.getCurrentSession()
				.createQuery(
						"UPDATE QuestionOptions  SET ansDescription=:ansDescription ,questionId=:questionId where quesOpId=:quesOpId")
				.setParameter("ansDescription",
						questionOptions.getAnsDescription()).setParameter(
						"questionId", questionOptions.getQuestionId())
				.setParameter("quesOpId", questionOptions.getQuesOpId())
				.executeUpdate();
	}
	@Transactional
	public void deleteQuestionOptionsByQuestionId(Long questionId) {
		sessionFactory.getCurrentSession().createQuery(
				"delete from  QuestionOptions where questionId=:questionId")
				.setParameter("questionId", questionId).executeUpdate();
	}
	public List<QuestionOptions> getQuestionOptionsByQuesOpId(Long quesOpId) {
		return sessionFactory.getCurrentSession().createQuery(
				"from QuestionOptions where quesOpId=:quesOpId").setParameter(
				"quesOpId", quesOpId).list();
	}
}
