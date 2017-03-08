package xyz.dddog.blog.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import xyz.dddog.blog.domain.model.Entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

	public Page<Post> findByCategoryId(int categoryId, Pageable pageable);
	
	public Page<Post> findByPostTagListTagName(String tagName, Pageable pageable);
}
