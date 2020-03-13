package com.niit.quizapp.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.quizapp.dao.QuestionsDAO;
import com.niit.quizapp.dao.StudentDAO;
import com.niit.quizapp.model.Questions;
import com.niit.quizapp.model.Student;

@Controller
public class LoginController {

	@Autowired
	StudentDAO studentDAO;
	@Autowired
	Student student;

	@Autowired
	private QuestionsDAO questionsDAO;

	@RequestMapping(value = "/login_session_attributes")
	public ModelAndView login_session_attributes(HttpSession session, Model model,
			@RequestParam(value = "username") String id) {

		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		System.out.println("inside security check");

		session.setAttribute("name", name);

		student = studentDAO.get(id);

		session.setAttribute("LoggedInUser", name);

		session.setAttribute("LoggedIn", "true");

		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();

		String role = "ROLE_USER";
		ModelAndView mv = new ModelAndView("questionpaperresult");
		
		mv.addObject("questions", new Questions());
		mv.addObject("languages", questionsDAO.listLanguages());
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals(role)) {
				return mv;
			} else {
				session.setAttribute("isAdmin", "true");
			}
		}

		return new ModelAndView("addquestion");
	}

	@RequestMapping("/perform_logout")
	public ModelAndView showLogout(HttpServletRequest request, HttpSession session) {
		System.out.println("logout");
		ModelAndView mv = new ModelAndView("Logout");
		session.setAttribute("LogOutMessage", "You have Successfully Logged Out.");
		session.invalidate();
		session = request.getSession(true);
		mv.addObject("LogOutMessage", "You have Successfully Logged Out.");
		mv.addObject("loggedOut", "true");
		return mv;
	}
}
