package xyz.dddog.blog.domain.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.dddog.blog.domain.model.UserSession;
import xyz.dddog.blog.domain.model.Entity.Post;
import xyz.dddog.blog.domain.model.command.PostCommand;
import xyz.dddog.blog.domain.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private TagService tagService;

	public Post writePost(PostCommand postCommand, UserSession user) {
		
		postCommand.setUserid(user.getProviderUserId());
		postCommand.setName(user.getDisplayName());
		postCommand.setRegDate(new Date());
		
		Post post = postRepository.save(new Post(postCommand));
		
		postCommand.setId(post.getId());
		
		tagService.insertPostTag(postCommand);
		
		return post;
	}

}
