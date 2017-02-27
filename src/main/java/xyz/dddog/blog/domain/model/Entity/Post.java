package xyz.dddog.blog.domain.model.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue
	private long id;
	
	private String userid;
	
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
}
