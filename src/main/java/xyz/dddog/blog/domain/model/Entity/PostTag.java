package xyz.dddog.blog.domain.model.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(exclude = "post")
@Entity
@NoArgsConstructor
public class PostTag {

	public PostTag(long postId, long tagId) {
		this.regDate = new Date();
		this.postId = postId;
		this.tagId = tagId;
	}

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postId", insertable = false, updatable = false)
	private Post post;

	private long postId;

	@ManyToOne
	@JoinColumn(name = "tagId", insertable = false, updatable = false)
	private Tag tag;

	private long tagId;

	private Date regDate;
}
