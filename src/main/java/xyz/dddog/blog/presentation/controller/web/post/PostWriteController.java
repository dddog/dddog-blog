package xyz.dddog.blog.presentation.controller.web.post;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.dddog.blog.domain.model.UserSession;
import xyz.dddog.blog.domain.model.command.PostCommand;
import xyz.dddog.blog.domain.service.CategoryService;
import xyz.dddog.blog.domain.service.PostService;

@Controller
@RequestMapping(value="/post/write")
public class PostWriteController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("categoryMap", categoryService.getCategoryMap());
		return "post/writeForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String write(@Valid PostCommand post, BindingResult bindingResult, UserSession user, Model model) {
//		System.out.println(userSession.getProviderUserId());
//		return "post/writeForm";
		
		model.addAttribute("categoryMap", categoryService.getCategoryMap());
		
		if (bindingResult.hasErrors()) {
			return "post/form";
		}

		return "redirect:/post/" + postService.writePost(post, user).getId();
	}
}
