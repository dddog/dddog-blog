package xyz.dddog.blog.domain.model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Account {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true)
	private String userid;
	
	private String password;
	
	private String role;
	private String nick;
	private String email;
}
