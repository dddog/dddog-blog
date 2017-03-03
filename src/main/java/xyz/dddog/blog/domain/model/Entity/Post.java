package xyz.dddog.blog.domain.model.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.BeanUtils;

import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.dddog.blog.domain.model.command.PostCommand;

@Data
@Entity
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue
	private int id;
	
	private String userid;
	private String name;
	
	@Column(nullable = false)
	String title;
	
	String subtitle;
	
	@Lob
	String content;
	
	Date regDate;
	Date updateDate;
	
	private int categoryId;
	
	private int hitCnt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId", insertable = false, updatable = false)
	private Category category;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	private List<PostTag> postTagList;
	
	public Post(PostCommand postCommand) {
		BeanUtils.copyProperties(postCommand, this);
	}
}
