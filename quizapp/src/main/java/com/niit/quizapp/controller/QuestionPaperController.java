package com.niit.quizapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quizapp.dao.QuestionOptionsDAO;
import com.niit.quizapp.dao.QuestionsDAO;
import com.niit.quizapp.model.QuestionOptions;
import com.niit.quizapp.model.QuestionPaper;
import com.niit.quizapp.model.Questions;

@Controller
public class QuestionPaperController {
	@Autowired
	private QuestionsDAO questionsDAO;
	@Autowired
	private QuestionOptionsDAO questionOptionsDAO;

	@RequestMapping(value="/questionpaper",method = RequestMethod.GET)
	public String showQuestionPaper(HttpServletRequest request, Map model,
			HttpSession session) {
		System.out.println("here in question paper");
		List questionPaperList = new ArrayList();
		List questonIdList = new ArrayList();
		String questionIdInString = request.getParameter("questionId");
		if (questionIdInString != null) {
			Long questionId = Long.parseLong(questionIdInString);
			QuestionPaper questionPaperCommand1 = new QuestionPaper();

			List questionlist = questionsDAO
					.getTenRandomQuestionsByLanguageId(questionId);

			for (int i = 0; i < questionlist.size(); i++) {
				List questionOptionsList = new ArrayList();
				QuestionPaper questionPaperCommand = new QuestionPaper();
				Questions questions = new Questions();
				questions = (Questions) questionlist.get(i);

				// set questonId in questonIdList
				questonIdList.add(i, questions.getQuestionId());
				questionPaperCommand.setQuestionId(questions.getQuestionId());
				questionPaperCommand.setQuestion(questions.getQuestion());

				questionOptionsList = questionOptionsDAO
						.getQuestionOptionsByQuestionId(questions
								.getQuestionId());
				if (questionOptionsList != null
						&& questionOptionsList.size() > 0) {
					QuestionOptions questionOptions1 = (QuestionOptions) questionOptionsList
							.get(0);
					QuestionOptions questionOptions2 = (QuestionOptions) questionOptionsList
							.get(1);
					QuestionOptions questionOptions3 = (QuestionOptions) questionOptionsList
							.get(2);
					QuestionOptions questionOptions4 = (QuestionOptions) questionOptionsList
							.get(3);
					if (questionOptions1 != null) {
						questionPaperCommand.setOption1Id(questionOptions1
								.getQuesOpId());
						questionPaperCommand.setOption1(questionOptions1
								.getAnsDescription());
					}
					if (questionOptions2 != null) {
						questionPaperCommand.setOption2Id(questionOptions2
								.getQuesOpId());
						questionPaperCommand.setOption2(questionOptions2
								.getAnsDescription());
					}
					if (questionOptions3 != null) {
						questionPaperCommand.setOption3Id(questionOptions3
								.getQuesOpId());
						questionPaperCommand.setOption3(questionOptions3
								.getAnsDescription());
					}
					if (questionOptions4 != null) {
						questionPaperCommand.setOption4Id(questionOptions4
								.getQuesOpId());
						questionPaperCommand.setOption4(questionOptions4
								.getAnsDescription());
					}
				}
				questionPaperList.add(questionPaperCommand);
				
			}
		}
		System.out.println("Question Paper List"+questionPaperList.size());
		session.setAttribute("questonIdList", questonIdList);
		model.put("questionPaperList", questionPaperList);
		return "/questionpaper";
	}

	@RequestMapping(value="/process",method = RequestMethod.POST)
	public ModelAndView processQuestionPaper(Map model,
			HttpServletRequest request, HttpSession session) {
		String[] question = request.getParameterValues("question");
		int rightAnswer = 0;
		for (int i = 0; i < question.length; i++) {
			if (request.getParameter("quesNum[" + i + "]") != null
					&& request.getParameter("option[" + i + "]") != null) {
				List<Questions> questionlist = new ArrayList<Questions>();
				Long questionId = Long.parseLong(request
						.getParameter("quesNum[" + i + "]"));
				Long rightOption = Long.parseLong(request
						.getParameter("option[" + i + "]"));
				questionlist = questionsDAO
						.getQuestionsByQuestionId(questionId);
				if (questionlist != null && questionlist.size() > 0) {
					Questions questions = new Questions();
					questions = questionlist.get(0);
					int comp = rightOption
							.compareTo(questions.getRightOption());
					if (comp == 0) {
						rightAnswer++;
					}
				}
			}
		}
		session.setAttribute("totalQuestion", question.length);
		session.setAttribute("rightAnswer", rightAnswer);
		session.setAttribute("wongAnswer", (question.length) - rightAnswer);

		return new ModelAndView("redirect:questionpaperresult");
	}
}
