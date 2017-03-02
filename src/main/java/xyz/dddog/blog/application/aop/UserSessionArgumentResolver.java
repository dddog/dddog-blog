package xyz.dddog.blog.application.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import xyz.dddog.blog.domain.model.UserSession;
import xyz.dddog.blog.domain.model.Entity.Account;
import xyz.dddog.blog.domain.repository.AccountRepository;

public class UserSessionArgumentResolver implements HandlerMethodArgumentResolver {

	AccountRepository accountRepository;
	
	public UserSessionArgumentResolver(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return UserSession.class.isAssignableFrom(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if( this.supportsParameter(parameter) ) {
			Account account = accountRepository.findByUserid(authentication.getName());
			return new UserSession(account.getUserid(), account.getEmail(), account.getNick());
		} else {
			return WebArgumentResolver.UNRESOLVED;
		}
		//return webRequest.getAttribute("_USER", RequestAttributes.SCOPE_REQUEST);
	}
}
