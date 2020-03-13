package com.niit.quizapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quizapp.dao.StudentDAO;
import com.niit.quizapp.model.Questions;
import com.niit.quizapp.model.Student;



@Controller
public class HomeController {
	
	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	Student student;
	
	@RequestMapping("/")
	public String showHome()
	{
		return "index";
	}
	@RequestMapping("/login")
	public String showLogin()
	{
		return "login";
	}
	@RequestMapping("/register")
	public ModelAndView showRegister()
	{
		ModelAndView mv= new ModelAndView("register");
		return mv;
	}	
	
	@ModelAttribute
	public Student returnObject()
	{
		return new Student(); 
	}
	@RequestMapping(value = "/checkRegister", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("student") Student student, BindingResult result, HttpServletRequest request,Model model)
	{
		student.setEnabled("true");
		student.setRole("ROLE_USER");
		
		studentDAO.saveOrUpdate(student);
		
		return "login";
	}
	@RequestMapping("/addquestion")
	public String showQuestions(Model model)
	{
		model.addAttribute("questions", new Questions());
		return "addquestion";
		
	}
	
	/*@RequestMapping("/questionlist")
	public ModelAndView showQuestionList()
	{
		ModelAndView mv= new ModelAndView("questionlist");
		return mv;
	}*/	
	@RequestMapping("/searchquestion")
	public String searchQuestionList(Model model)
	{
		model.addAttribute("question", new Questions());
		return "searchquestion";
	}	
	@RequestMapping("/Logout")
	public String showLogout()
	{
		return "Logout";
	}
	/*@RequestMapping("/selectpaper")
	public String selectQuestions(Model model)
	{
		model.addAttribute("language", new Questions());
		return "selectpaper";
		
	}*/
	@RequestMapping("/questionpaper")
	public String selectQuestionPaper(Model model)
	{
		model.addAttribute("question", new Questions());
		return "questionpaper";
		
	}
	@RequestMapping("/questionpaperresult")
	public String selectPaper(Model model)
	{
		model.addAttribute("question", new Questions());
		return "questionpaperresult";
		
	}
	
}
