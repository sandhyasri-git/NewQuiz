package com.niit.quizapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quizapp.dao.QuestionOptionsDAO;
import com.niit.quizapp.dao.QuestionsDAO;
import com.niit.quizapp.model.QuestionOptions;
import com.niit.quizapp.model.Questions;

@Controller
public class QuestionListController {
	@Autowired
	private QuestionsDAO questionsDAO;
	@Autowired
	private QuestionOptionsDAO questionOptionsDAO;

	@GetMapping("/userquestionlist")
	public String showQuestionList(Model model, HttpServletRequest request, HttpSession session) {

		List allQuestionList = new ArrayList();
		List questionlist = new ArrayList();
		System.out.println("show questions list");

		questionlist = questionsDAO.listQuestions();
		System.out.println("size" + questionlist.size());

		for (int i = 0; i < questionlist.size(); i++) {

			List questionOptionsList = new ArrayList();
			Questions questions = new Questions();
			questions = (Questions) questionlist.get(i);
			System.out.println("in loop " + questions.getLanguageName());

			questionOptionsList = questionOptionsDAO.getQuestionOptionsByQuestionId(questions.getQuestionId());
			System.out.println("question options list " + questionOptionsList);
			if (questionOptionsList != null && questionOptionsList.size() > 0) {
				QuestionOptions questionOptions1 = (QuestionOptions) questionOptionsList.get(0);
				QuestionOptions questionOptions2 = (QuestionOptions) questionOptionsList.get(1);
				QuestionOptions questionOptions3 = (QuestionOptions) questionOptionsList.get(2);
				QuestionOptions questionOptions4 = (QuestionOptions) questionOptionsList.get(3);
			}
			allQuestionList.add(questionlist);
			System.out.println("all questions list " + allQuestionList.size());
		}
		model.addAttribute("allQuestionList", questionlist);
		return "userquestionlist";
	}

}
