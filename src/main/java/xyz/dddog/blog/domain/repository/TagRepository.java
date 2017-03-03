package xyz.dddog.blog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.dddog.blog.domain.model.Entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer>{

	Tag findByName(String tagName);

}
