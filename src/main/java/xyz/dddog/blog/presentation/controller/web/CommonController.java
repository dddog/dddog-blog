package xyz.dddog.blog.presentation.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping("/access_denied")
	public String access_denied() {
		return "/common/access_denied";
	}
}
