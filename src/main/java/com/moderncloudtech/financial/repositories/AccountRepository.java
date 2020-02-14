package com.moderncloudtech.financial.repositories;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.moderncloudtech.financial.accounts.Account;


@Repository
//@RepositoryRestResource
@RepositoryRestResource(collectionResourceRel = "Account", path = "Account")
//@RepositoryRestResource(exported = false)
public interface AccountRepository extends CrudRepository <Account, Long>{

	@Query("select a from Account a where a.currency = :currency")
	List<Account> findByCurrency(@Param("currency") String currency);
	
	@Query("select a from Account a")
	List<Account> getAccounts();
	
	
	@Query("select a from Account a where a.holderId = :holderId")
	List<Account> getByAccountHolder(@Param("holderId") Long holderId);
	
	
}
