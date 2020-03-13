package com.niit.quizapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quizapp.dao.QuestionsDAO;
import com.niit.quizapp.model.Questions;

@Controller
@RequestMapping(value="/searchquestion")
public class SearchQuestionController {
	
	@Autowired
	private QuestionsDAO questionsDAO;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String showSearchQuestion(Model model,HttpSession session){
		   
		  
		   model.addAttribute("languagelist", questionsDAO.listLanguages());
		   return "searchquestion";
	 }
	
	@RequestMapping(value = "/searchquestion", method = RequestMethod.POST)
	public ModelAndView processSearchQuestion(@Valid@ModelAttribute("question") Questions questions, BindingResult result, HttpServletRequest request,Model model){
		   Long questionId=questions.getQuestionId();
		   System.out.println("question ID "+questionId);
		   if(questionId==-1){
			  model.addAttribute("languagelist", questionsDAO.listLanguages());
			  model.addAttribute("errormessage", "Select Language");
			  model.addAttribute("question", new Questions());
			  return new ModelAndView("searchquestion");
		   }
		   return new ModelAndView("redirect:questionlist?questionId="+questions.getQuestionId());
	 }
}
