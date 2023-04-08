package com.web.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/welcome")
//	@RequestMapping(value="/welcome", method=RequestMethod.GET)//舊寫法
	public String welcome(Model model) {
		model.addAttribute("title", "歡迎蒞臨君雅網路商城!!!");
		model.addAttribute("subtitle", "網路上獨一無二的購物天堂");
		return "welcome";	//WEB-INF/views/welcome.jsp	//view logical name
	}
	
	@GetMapping("/")
	public String index() {
		return "index";	//WEB-INF/views/index.jsp	//view logical name
	}
}
