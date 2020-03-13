package com.niit.quizapp.controller;

import java.util.Map;

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
@RequestMapping("/selectpaper")
public class SelectPaperController {
	@Autowired
	private QuestionsDAO questionsDAO;

	@RequestMapping(method = RequestMethod.GET)
	
	public String showSelectPaper(Model model, HttpSession session) {
		
		/*Questions language = new Questions();
		
		model.put("language", language);
		model.put("languagelist", questionsDAO.listLanguages());
		return "/selectpaper";*/
		model.addAttribute("languagelist", questionsDAO.listLanguages());
		   return "selectpaper";
		
	}

	@RequestMapping(value="/selectpaper",method = RequestMethod.POST)
	public ModelAndView processSelectPaper(@Valid @ModelAttribute("language") Questions language, BindingResult result, HttpServletRequest request,Model model) {
		model.addAttribute("language", new Questions());
		String langname = language.getLanguageName();
		System.out.println(langname);
		if (langname == null) {
			System.out.println("in select paper");
			model.addAttribute("languagelist", questionsDAO.listLanguages());
			model.addAttribute("errormessage", "Select Language");
			return new ModelAndView("/selectpaper");
		}
		return new ModelAndView("redirect:questionpaper?languageId="
				+ language.getLanguageName());
	}
}