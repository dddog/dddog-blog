package xyz.dddog.blog.domain.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.dddog.blog.domain.model.Entity.Category;
import xyz.dddog.blog.domain.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
	
	public Map<Integer, String> getCategoryMap() {
		return categoryRepository.findAll().stream().collect(Collectors.toMap(Category::getId, Category::getName));
	}
}
