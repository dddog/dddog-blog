package xyz.dddog.blog.domain.model.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UploadFile {

	@Id
	@GeneratedValue
	long id;
	
	@Column
	String fileName;
	
	@Column
	String saveFileName;
	
	@Column
	String filePath;
	
	@Column
	String contentType;
	
	@Column
	long size;
	
	Date regDate;
}
