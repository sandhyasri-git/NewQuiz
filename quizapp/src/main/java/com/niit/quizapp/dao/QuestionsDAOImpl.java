package com.niit.quizapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.quizapp.model.Questions;

@Repository("questionsDAO")
@EnableTransactionManagement
public class QuestionsDAOImpl implements QuestionsDAO {

	public QuestionsDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private SessionFactory sessionFactory;

	public QuestionsDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Questions> listQuestions() {
		return (List<Questions>) sessionFactory.getCurrentSession().createCriteria(Questions.class)
				.addOrder(Order.desc("questionId")).list();
	}

	@Transactional
	public List<Questions> getQuestionsByQuestionId(Long questionId) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Questions where questionId=:questionId ORDER BY questionId DESC")
				.setParameter("questionId", questionId).list();
	}

	@Transactional
	public void saveQuestions(Questions questions) {
		sessionFactory.getCurrentSession().save(questions);
	}

	@Transactional
	public void updateQuestions(Questions questions) {
		sessionFactory.getCurrentSession().createQuery(
				"UPDATE Questions SET question=:question , rightOption=:rightOption where questionId=:questionId")
				.setParameter("question", questions.getQuestion())
				.setParameter("rightOption", questions.getRightOption())
				.setParameter("questionId", questions.getQuestionId()).executeUpdate();
	}

	@Transactional
	public void deleteQuestions(Questions questions) {
		sessionFactory.getCurrentSession().createQuery("delete from Questions where questionId=:questionId")
				.setParameter("questionId", questions.getQuestionId()).executeUpdate();
	}

	@Transactional
	public List<String> listLanguages() {
		return sessionFactory.getCurrentSession().createNativeQuery("select distinct lang_name from questions")
				.getResultList();

	}

	public List<Questions> getTenRandomQuestionsByLanguageId(Long questionId) {
		return (List<Questions>) sessionFactory.getCurrentSession()
				.createQuery("from Questions where questionId=:questionId order by rand()")
				.setParameter("languageId", questionId).setMaxResults(10).list();
	}
}
