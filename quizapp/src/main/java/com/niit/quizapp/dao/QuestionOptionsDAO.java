package com.niit.quizapp.dao;

import java.util.List;

import com.niit.quizapp.model.QuestionOptions;


public interface QuestionOptionsDAO {

	public List<QuestionOptions> listQuestionOptions();

	public List<QuestionOptions> getQuestionOptionsByQuestionId(Long questionId);

	public void saveQuestionOptions(QuestionOptions questionOptions);

	public void updateQuestionOptions(QuestionOptions questionOptions);

	public void deleteQuestionOptionsByQuestionId(Long questionId);
	public List<QuestionOptions> getQuestionOptionsByQuesOpId(Long quesOpId);
}
