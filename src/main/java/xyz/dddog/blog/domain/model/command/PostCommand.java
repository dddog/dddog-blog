package xyz.dddog.blog.domain.model.command;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.BeanUtils;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import xyz.dddog.blog.domain.model.Entity.Post;
import xyz.dddog.blog.domain.model.Entity.PostTag;

@Data
@Slf4j
@NoArgsConstructor
public class PostCommand {

	long id;

	String userId;
	String name;

	@NotNull
	@Size(min = 1, max = 255)
	String title;

	@Size(max = 255)
	String subtitle;

	@NotNull
	@Size(min = 1)
	String content;

	Date regDate;

	String _csrf;

	@Min(value = 1)
	private int categoryId;

	String tags = "";

	public PostCommand(Post post) {
		BeanUtils.copyProperties(post, this);

		for (PostTag postTag : post.getPostTagList()) {
			log.debug("postTag = {}", postTag.getTag());
			tags = tags + postTag.getTag().getName() + " ";
		}
	}
}
