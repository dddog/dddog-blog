package xyz.dddog.blog.presentation.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping({"/","/home"})
	public String home(Model model) {
		return "home";
	}
}
