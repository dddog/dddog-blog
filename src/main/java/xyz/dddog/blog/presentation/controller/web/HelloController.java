package xyz.dddog.blog.presentation.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.dddog.blog.domain.model.Entity.Post;
import xyz.dddog.blog.domain.repository.CategoryRepository;
import xyz.dddog.blog.domain.repository.PostRepository;

@Controller
public class HelloController {

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping({"/","/home"})
	public String home(Model model) {
		
		Page<Post> postPage;
		Pageable pageable = new PageRequest(0, 6, Direction.DESC, "id");
		postPage = postRepository.findAll(pageable);

		model.addAttribute("postPage", postPage);
		model.addAttribute("categoryList", categoryRepository.findAll());
		
		return "home";
	}
}
