package xyz.dddog.blog.presentation.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import xyz.dddog.blog.application.utility.UserDulicatedException;
import xyz.dddog.blog.commons.ErrorResponse;
import xyz.dddog.blog.domain.model.Entity.Account;
import xyz.dddog.blog.domain.repository.AccountRepository;
import xyz.dddog.blog.domain.service.impl.UserDetailsImpl;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping("/login")
	public String login() {
		return "connect/login";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "connect/join";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Account account) {
		
		String userid = account.getUserid();
		if( accountRepository.findByUserid(userid) != null ) {
			log.error("user duplicated exception. {}", userid);
			throw new UserDulicatedException(userid);
		}
		
		if( account.getRole() == null ) {
			account.setRole("ROLE_USER");
		}
		
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		// 회원정보 데이터베이스에 저장
		accountRepository.save(account);

		// SecurityContextHolder에서 Context를 받아 인증 설정
		UserDetailsImpl userDetails = new UserDetailsImpl(account);
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/";
	}
	
	@ExceptionHandler(UserDulicatedException.class)
	public ResponseEntity handleUserDuplicatedException(UserDulicatedException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("[" + e.getUserid() + "] 중복 아이디 입니다.");
		errorResponse.setCode("duplicated.username.exception");
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
