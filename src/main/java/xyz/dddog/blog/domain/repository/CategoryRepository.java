package xyz.dddog.blog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.dddog.blog.domain.model.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
