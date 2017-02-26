package xyz.dddog.blog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.dddog.blog.domain.model.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	public Account findByUserid(String userid);
}
