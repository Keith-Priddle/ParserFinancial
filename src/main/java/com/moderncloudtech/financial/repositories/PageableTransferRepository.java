package com.moderncloudtech.financial.repositories;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */
import org.springframework.data.repository.PagingAndSortingRepository;

import com.moderncloudtech.financial.accounts.Transfer;

public interface PageableTransferRepository extends PagingAndSortingRepository<Transfer, Long>{

	
}
