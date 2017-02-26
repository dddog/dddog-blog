package xyz.dddog.blog.application.utility;

public class UserDulicatedException extends RuntimeException {

	String userid;
	
	public UserDulicatedException(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}
	
}
