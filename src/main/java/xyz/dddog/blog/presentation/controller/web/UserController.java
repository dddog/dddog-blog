package xyz.dddog.blog.presentation.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/login")
	public String login() {
		return "connect/login";
	}
	@RequestMapping("/loginProcessing")
	public String loginProcessing() {
		
		return "/";
	}
	@RequestMapping("/join")
	public String join() {
		return "connect/join";
	}
}