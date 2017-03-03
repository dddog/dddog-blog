package xyz.dddog.blog.presentation.controller.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.dddog.blog.domain.model.Entity.Category;
import xyz.dddog.blog.domain.repository.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;

	@ResponseBody
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public Category add(@RequestParam(value = "categoryName", required = true) String categoryName) {

		Category category = new Category();
		category.setName(categoryName);
		category.setRegDate(new Date());

		return categoryRepository.save(category);
	}
	
}
