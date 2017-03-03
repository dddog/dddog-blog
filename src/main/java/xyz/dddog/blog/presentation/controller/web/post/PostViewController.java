package xyz.dddog.blog.presentation.controller.web.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import xyz.dddog.blog.domain.repository.PostRepository;

@Slf4j
@Controller
public class PostViewController {

	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping("/post/{id}")
	public String view(Model model, @PathVariable int id) {

		model.addAttribute("post", postRepository.findOne(id));

		log.debug("post = {}", postRepository.findOne(id));

		return "post/post";
	}
}
