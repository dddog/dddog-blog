package xyz.dddog.blog.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import xyz.dddog.blog.domain.model.Entity.Account;
import xyz.dddog.blog.domain.repository.AccountRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		Account user = accountRepository.findByUserid(userid);
		if( user == null ) {
			throw new UsernameNotFoundException(userid);
		}
		return new UserDetailsImpl(user);
	}

}
