package com.niit.quizapp.dao;

import java.util.List;
import java.util.Set;

import com.niit.quizapp.model.Questions;

public interface QuestionsDAO {
	
	public List<Questions> listQuestions();
	public List<Questions> getQuestionsByQuestionId(Long questionId);

	public void saveQuestions(Questions questions);

	public void updateQuestions(Questions questions);

	public void deleteQuestions(Questions questions);
	public List<String> listLanguages();
	public List<Questions> getTenRandomQuestionsByLanguageId(Long languageId);
}
