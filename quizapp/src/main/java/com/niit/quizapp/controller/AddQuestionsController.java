package com.niit.quizapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.quizapp.dao.QuestionOptionsDAO;
import com.niit.quizapp.dao.QuestionsDAO;
import com.niit.quizapp.model.QuestionOptions;
import com.niit.quizapp.model.Questions;

@Controller

public class AddQuestionsController {

	@Autowired
	private QuestionsDAO questionsDAO;
	@Autowired
	private QuestionOptionsDAO questionOptionsDAO;
	
	
	@RequestMapping(value = "/addquestion", method = RequestMethod.POST)
	public String showQuestion(@Valid @ModelAttribute("questions") Questions questions, BindingResult result, HttpServletRequest request,Model model) {
		
		model.addAttribute("questions",new Questions());
		
			questionsDAO.saveQuestions(questions);
				
		String pageHeading = "Add Question";
				QuestionOptions questionOptions1 = new QuestionOptions();
		questionOptions1
				.setAnsDescription(questions.getOption1());
		questionOptions1.setQuestionId(questions.getQuestionId());
		questionOptionsDAO.saveQuestionOptions(questionOptions1);

		QuestionOptions questionOptions2 = new QuestionOptions();
		questionOptions2
				.setAnsDescription(questions.getOption2());
		questionOptions2.setQuestionId(questions.getQuestionId());
		questionOptionsDAO.saveQuestionOptions(questionOptions2);

		QuestionOptions questionOptions3 = new QuestionOptions();
		questionOptions3
				.setAnsDescription(questions.getOption3());
		questionOptions3.setQuestionId(questions.getQuestionId());
		questionOptionsDAO.saveQuestionOptions(questionOptions3);

		QuestionOptions questionOptions4 = new QuestionOptions();
		questionOptions4
				.setAnsDescription(questions.getOption4());
		questionOptions4.setQuestionId(questions.getQuestionId());
		questionOptionsDAO.saveQuestionOptions(questionOptions4);

		int comp1 = 1;
		int comp2 = 1;
		int comp3 = 1;
		int comp4 = 1;
		comp1 = (questions.getRightOption())
				.compareTo(new Long(1));
		comp2 = (questions.getRightOption())
				.compareTo(new Long(2));
		comp3 = (questions.getRightOption())
				.compareTo(new Long(3));
		comp4 = (questions.getRightOption())
				.compareTo(new Long(4));

		if (comp1 == 0) {
			questions.setRightOption(questionOptions1.getQuesOpId());
			questionsDAO.updateQuestions(questions);
		}
		if (comp2 == 0) {
			questions.setRightOption(questionOptions2.getQuesOpId());
			questionsDAO.updateQuestions(questions);
		}
		if (comp3 == 0) {
			questions.setRightOption(questionOptions3.getQuesOpId());
			questionsDAO.updateQuestions(questions);
		}
		if (comp4 == 0) {
			questions.setRightOption(questionOptions4.getQuesOpId());
			questionsDAO.updateQuestions(questions);
		}
	else {
		// update Question and Answer
		questions.setQuestionId(questions.getQuestionId());

		List questionoptionslist = questionOptionsDAO
				.getQuestionOptionsByQuestionId(questions
						.getQuestionId());
		if (questionoptionslist != null
				&& questionoptionslist.size() > 0) {
			questionOptions1 = (QuestionOptions) questionoptionslist
					.get(0);
			questionOptions2 = (QuestionOptions) questionoptionslist
					.get(1);
			questionOptions3 = (QuestionOptions) questionoptionslist
					.get(2);
			questionOptions4 = (QuestionOptions) questionoptionslist
					.get(3);

			questionOptions1.setAnsDescription(questions.getOption1());
			questionOptions2.setAnsDescription(questions
					.getOption2());
			questionOptions3.setAnsDescription(questions
					.getOption3());
			questionOptions4.setAnsDescription(questions
					.getOption4());

			questionOptionsDAO
					.updateQuestionOptions(questionOptions1);
			questionOptionsDAO
					.updateQuestionOptions(questionOptions2);
			questionOptionsDAO
					.updateQuestionOptions(questionOptions3);
			questionOptionsDAO
					.updateQuestionOptions(questionOptions4);

			if ((questions.getRightOption())
					.compareTo(new Long(1)) == 0) {
				questions
						.setRightOption(questionOptions1.getQuesOpId());
			}
			if ((questions.getRightOption())
					.compareTo(new Long(2)) == 0) {
				questions
						.setRightOption(questionOptions2.getQuesOpId());
			}
			if ((questions.getRightOption())
					.compareTo(new Long(3)) == 0) {
				questions
						.setRightOption(questionOptions3.getQuesOpId());
			}
			if ((questions.getRightOption())
					.compareTo(new Long(4)) == 0) {
				questions
						.setRightOption(questionOptions4.getQuesOpId());
			}

			questionsDAO.updateQuestions(questions);
		}
	}

	return "questionlist";
	
	}

}

