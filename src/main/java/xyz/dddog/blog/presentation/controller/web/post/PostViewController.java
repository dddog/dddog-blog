package xyz.dddog.blog.presentation.controller.web.post;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import xyz.dddog.blog.domain.model.Entity.Post;
import xyz.dddog.blog.domain.repository.CategoryRepository;
import xyz.dddog.blog.domain.repository.PostRepository;

@Slf4j
@Controller
public class PostViewController {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping("/post/{id}")
	public String view(Model model, @PathVariable int id) {

		model.addAttribute("post", postRepository.findOne(id));
		model.addAttribute("categoryList", categoryRepository.findAll());

		log.debug("post = {}", postRepository.findOne(id));

		return "post/post";
	}
	
	@RequestMapping(value = { "/post/list", "/category/{categoryId}/post/list" })
	public String list(Model model, @PathVariable Optional<Integer> categoryId) {
		
		Page<Post> postPage;
		Pageable pageable = new PageRequest(0, 6, Direction.DESC, "id");
		
		int activeCategory = -1;
		
		if( categoryId.isPresent() ) {
			activeCategory = categoryId.get();
			postPage = postRepository.findByCategoryId(categoryId.get(), pageable);
		} else {
			postPage = postRepository.findAll(pageable);
		}
		
		model.addAttribute("postPage", postPage);
		model.addAttribute("categoryList", categoryRepository.findAll());
		model.addAttribute("activeCategoryId", activeCategory);
		return "post/list";
	}
}
