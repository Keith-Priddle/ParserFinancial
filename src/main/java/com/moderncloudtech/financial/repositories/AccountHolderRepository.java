package com.moderncloudtech.financial.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.moderncloudtech.financial.accounts.AccountHolder;

@Repository
@RepositoryRestResource(collectionResourceRel = "AccountHolder", path = "AccountHolder")
public interface AccountHolderRepository extends CrudRepository<AccountHolder, Long> {

	
	@Query("select a from AccountHolder a")
	List<AccountHolder> GetAllAH();
	
	
}	
