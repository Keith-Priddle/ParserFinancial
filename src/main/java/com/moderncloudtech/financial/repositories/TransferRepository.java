package com.moderncloudtech.financial.repositories;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.moderncloudtech.financial.accounts.Account;
import com.moderncloudtech.financial.accounts.Transfer;


@Repository
@RepositoryRestResource(collectionResourceRel = "Transfer", path = "Transfer")
public interface TransferRepository extends CrudRepository<Transfer, Long> {

	@Query("select t from Transfer t where t.destination = :destination")
	List<Transfer> findByDestination(@Param("destination") Long destination);

	
	@Query("select t from Transfer t where t.destination = :destination")
	List<Transfer> findBySource(Long destination, Sort sort);
	
	@Query("select a from Account a where a.accountId = :id")
	Account getAccountById(Long id);
	
	@Query("select a.currency from Account a where a.accountId = :id")
	String getAccountCurrency(Long id);
	
	@Query("select t from Transfer t")
	List<Transfer> getTransfers();

}
