package xyz.dddog.blog.presentation.controller.web.post;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import xyz.dddog.blog.domain.model.UserSession;
import xyz.dddog.blog.domain.model.command.PostCommand;
import xyz.dddog.blog.domain.service.CategoryService;
import xyz.dddog.blog.domain.service.PostService;

@Slf4j
@Controller
@RequestMapping(value="/post/write")
public class PostWriteController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(PostCommand post, Model model) {
		log.info("/post/write : {}", "GET");
		model.addAttribute("categoryMap", categoryService.getCategoryMap());
		return "post/writeForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String write(@Valid PostCommand post, BindingResult bindingResult, UserSession user, Model model, HttpServletRequest req) {
		log.info("UserSession : {}", user.getProviderUserId());
		model.addAttribute("categoryMap", categoryService.getCategoryMap());
		
		if (bindingResult.hasErrors()) {
			log.info("bindingResult.hasErrors() -> {}", bindingResult);
			return "post/writeForm";
		}
		
		return "redirect:/post/" + postService.writePost(post, user).getId();
	}
}
