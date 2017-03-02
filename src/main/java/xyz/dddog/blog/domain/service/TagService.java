package xyz.dddog.blog.domain.service;

import java.util.HashSet;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xyz.dddog.blog.domain.model.Entity.PostTag;
import xyz.dddog.blog.domain.model.Entity.Tag;
import xyz.dddog.blog.domain.model.command.PostCommand;
import xyz.dddog.blog.domain.repository.PostTagRepository;
import xyz.dddog.blog.domain.repository.TagRepository;

@Slf4j
@Service
public class TagService {
	
	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private PostTagRepository postTagRepository;
	
	public void insertPostTag(PostCommand postCommand) {
		HashSet<String> hashSet = tagNamesToHashSet(postCommand.getTags());

		log.debug("hashSet = {}", hashSet);

		insertTag(postCommand.getId(), hashSet);
	}
	
	private HashSet<String> tagNamesToHashSet(String postTagNames) {

		StringTokenizer tokenTag = new StringTokenizer(postTagNames.trim().replaceAll("[ ]+", " "), " ");

		HashSet<String> hashSet = new HashSet<>();

		while (tokenTag.hasMoreElements()) {
			hashSet.add(tokenTag.nextToken());
			if (hashSet.size() >= 10) {
				break;
			}
		}

		return hashSet;
	}
	
	
	private void insertTag(long postId, HashSet<String> hashSet) {
		for (String tagName : hashSet) {
			if (tagName.equals("")) {
				continue;
			}

			Tag tag = tagRepository.findByName(tagName);
			if (tag == null) {
				tag = tagRepository.save(new Tag(tagName));
			}

			postTagRepository.save(new PostTag(postId, tag.getId()));
		}
	}
	
}
