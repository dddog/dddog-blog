package xyz.dddog.blog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.dddog.blog.domain.model.Entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
