package xyz.dddog.blog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.dddog.blog.domain.model.Entity.PostTag;

public interface PostTagRepository extends JpaRepository<PostTag, Integer>{

}
