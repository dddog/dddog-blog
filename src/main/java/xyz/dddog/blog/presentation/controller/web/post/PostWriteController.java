package xyz.dddog.blog.presentation.controller.web.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.dddog.blog.domain.model.Entity.Account;

@Controller
@RequestMapping(value="/post/write")
public class PostWriteController {

	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {
		
		return "post/writeForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String write(BindingResult bindingResult, Account user, Model model) {
		
		return "post/writeForm";
	}
}
