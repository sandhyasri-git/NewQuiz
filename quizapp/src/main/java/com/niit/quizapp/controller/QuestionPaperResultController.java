package com.niit.quizapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.quizapp.dao.QuestionOptionsDAO;
import com.niit.quizapp.dao.QuestionsDAO;
import com.niit.quizapp.model.QuestionOptions;
import com.niit.quizapp.model.Questions;

@Controller
	@RequestMapping(value = "/questionpaperresult")
	public class QuestionPaperResultController {

		@Autowired
		private QuestionsDAO questionsDAO;
		@Autowired
		private QuestionOptionsDAO questionOptionsDAO;

		@RequestMapping(method = RequestMethod.GET)
		public String showQuestionPaperResult(Map model, HttpSession session) {
			
			List<Questions> questionPaperList = new ArrayList<Questions>();
			List questonIdList = (List) session.getAttribute("questonIdList");

			List questionlist = new ArrayList();
			for (int i = 0; i < questonIdList.size(); i++) {
				Long questionId = (Long) questonIdList.get(i);
				questionlist = questionsDAO
						.getQuestionsByQuestionId(questionId);
				if (questionlist != null && questionlist.size() > 0) {
					for (int j = 0; j < questionlist.size(); j++) {
						Questions Questions = new Questions();
						List questionOptionsList = new ArrayList();
						Questions questions = new Questions();
						questions = (Questions) questionlist.get(j);
						Questions.setQuestionId(questions
								.getQuestionId());
						Questions.setQuestion(questions.getQuestion());
						// questionOptionsList
						questionOptionsList = questionOptionsDAO
								.getQuestionOptionsByQuesOpId(questions
										.getRightOption());
						if (questionOptionsList != null
								&& questionOptionsList.size() > 0) {
							QuestionOptions questionOptions = (QuestionOptions) questionOptionsList
									.get(0);
							Questions.setOption1(questionOptions
									.getAnsDescription());

						}
						questionPaperList.add(Questions);
					}
				}
			}

			model.put("questionPaperList", questionPaperList);
			model.put("totalQuestion", session.getAttribute("totalQuestion"));
			model.put("rightAnswer", session.getAttribute("rightAnswer"));
			model.put("wongAnswer", session.getAttribute("wongAnswer"));

			session.removeAttribute("totalQuestion");
			session.removeAttribute("rightAnswer");
			session.removeAttribute("wongAnswer");

			return "/questionpaperresult";
		}


}
