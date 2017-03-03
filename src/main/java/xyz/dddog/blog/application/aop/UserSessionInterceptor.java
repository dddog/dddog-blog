package xyz.dddog.blog.application.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import xyz.dddog.blog.domain.model.UserSession;
import xyz.dddog.blog.domain.model.Entity.Account;
import xyz.dddog.blog.domain.repository.AccountRepository;

public class UserSessionInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	AccountRepository accountRepository;


	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Account account;

		try {
			account = accountRepository.findByUserid(authentication.getName());
		} catch (Exception e) {
			account = null;
		}

		if (account != null) {
			request.setAttribute("_USER", new UserSession(account.getUserid(), account.getEmail(), account.getNick()));
		}

		return true;
	}
}
