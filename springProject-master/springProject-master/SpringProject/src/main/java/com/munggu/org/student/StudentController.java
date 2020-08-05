package com.munggu.org.student;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping(value="/student")
	public String index(Model model, HttpSession session) {
		
		session.setAttribute("menu", "student");
		
		return "student/index";
	}
}
