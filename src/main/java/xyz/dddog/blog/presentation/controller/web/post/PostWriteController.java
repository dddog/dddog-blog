package xyz.dddog.blog.presentation.controller.web.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.dddog.blog.domain.model.Entity.Account;
import xyz.dddog.blog.domain.service.CategoryService;

@Controller
@RequestMapping(value="/post/write")
public class PostWriteController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("categoryMap", categoryService.getCategoryMap());
		return "post/writeForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String write(Account user, Model model) {
		System.out.println(user);
		return "post/writeForm";
	}
}
